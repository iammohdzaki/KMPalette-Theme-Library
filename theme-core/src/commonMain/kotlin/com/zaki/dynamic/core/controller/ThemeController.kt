package com.zaki.dynamic.core.controller

import com.zaki.dynamic.core.model.ThemeDefinition
import com.zaki.dynamic.core.model.ThemeFamily
import com.zaki.dynamic.core.model.ThemeId
import com.zaki.dynamic.core.model.ThemeMode
import com.zaki.dynamic.core.model.ThemeSelection
import com.zaki.dynamic.core.model.ThemeState
import com.zaki.dynamic.core.persistance.ThemeStore
import com.zaki.dynamic.core.provider.SystemThemeProvider
import com.zaki.dynamic.core.registry.ThemeRegistry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/**
 * Controller responsible for managing themes in the application.
 *
 * It coordinates between the [ThemeRegistry], [ThemeStore], and [SystemThemeProvider]
 * to provide theme state, persist user preferences, and resolve the effective theme.
 *
 * Usage:
 * ```
 * val controller = ThemeController(registry, store, system, defaultThemeId)
 * controller.setMode(ThemeMode.DARK)
 * controller.setExplicitTheme(themeId)
 * ```
 *
 * The controller exposes a reactive [state] flow that can be collected to observe changes
 * in the currently applied [ThemeState].
 *
 * @property registry Provides available themes and theme families.
 * @property store Persists and loads theme selections.
 * @property system Supplies system dark/light mode state.
 * @property defaultThemeId ID of the fallback theme if no match is found.
 */
class ThemeController(
    private val registry: ThemeRegistry,
    private val store: ThemeStore,
    val system: SystemThemeProvider,
    private val defaultThemeId: ThemeId
) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private val _state = MutableStateFlow<ThemeState?>(null)

    /**
     * Reactive state flow of the current theme.
     *
     * Emits the resolved [ThemeState] whenever the theme mode or explicit theme changes.
     * Initial value is resolved using [ThemeMode.SYSTEM] and falls back to the default theme.
     */
    val state: StateFlow<ThemeState> = _state.filterNotNull().stateIn(
        scope, SharingStarted.Eagerly, initialValue =
            resolve(ThemeSelection(ThemeMode.SYSTEM, null))
    )

    init {
        scope.launch {
            // Load previously saved theme selection or fall back to system mode
            val persisted = store.load() ?: ThemeSelection(
                ThemeMode.SYSTEM,
                null
            )
            _state.value = resolve(persisted)
        }
    }

    /**
     * Returns the complete list of available themes.
     */
    fun availableThemes(): List<ThemeDefinition> = registry.all()

    /**
     * Returns the list of available theme families.
     * Theme families group related themes (e.g., light/dark variants).
     */
    fun getAvailableThemeFamilies(): List<ThemeFamily> = registry.families()
    fun getAvailableThemeFamiliesInOrder(defaultThemeId: ThemeId): List<ThemeFamily> =
        registry.families().sortedByDescending { it.id == defaultThemeId }

    /**
     * Updates the theme mode (System, Dark, or Light).
     *
     * @param mode The new [ThemeMode] to apply.
     */
    fun setMode(mode: ThemeMode) {
        update(current().selection.copy(mode = mode))
    }

    /**
     * Sets an explicit theme by its ID.
     *
     * If `null`, the controller will use the default strategy
     * based on [ThemeMode] and available themes.
     *
     * @param themeId The ID of the theme to set, or `null` to clear.
     */
    fun setExplicitTheme(themeId: ThemeId?) {
        update(current().selection.copy(explicitThemeId = themeId))
    }

    /**
     * Applies the given theme selection, updates the state, and persists it.
     *
     * @param selection The new [ThemeSelection] to resolve and apply.
     */
    private fun update(selection: ThemeSelection) {
        val resolved = resolve(selection)
        _state.value = resolved
        scope.launch { store.save(selection) }
    }

    /**
     * Returns the current resolved [ThemeState].
     * If state is not yet initialized, falls back to [ThemeMode.SYSTEM].
     */
    private fun current(): ThemeState =
        _state.value ?: resolve(ThemeSelection(ThemeMode.SYSTEM, null))

    /**
     * Resolves a [ThemeSelection] into a [ThemeState].
     *
     * @param selection The selection containing mode and optional explicit theme.
     * @return The resolved [ThemeState].
     */
    private fun resolve(selection: ThemeSelection): ThemeState {
        val isDark = when (selection.mode) {
            ThemeMode.SYSTEM -> system.isSystemDark()
            ThemeMode.DARK -> true
            ThemeMode.LIGHT -> false
        }

        val theme = selection.explicitThemeId?.let { registry.get(it) }
            ?: pickDefault(isDark)

        // Ensure the resolved theme matches the requested mode (dark/light)
        // If the explicit theme doesn't match the mode, we should probably try to find the matching variant in the same family
        val finalTheme = if (theme.palette.isDark != isDark) {
             // Try to find the family of this theme
             val family = registry.families().find { it.light.id == theme.id || it.dark.id == theme.id }
             if (family != null) {
                 if (isDark) family.dark else family.light
             } else {
                 theme // Fallback if no family found (shouldn't happen if properly registered)
             }
        } else {
            theme
        }

        return ThemeState(selection, finalTheme)
    }

    /**
     * Picks the most appropriate default theme based on darkness preference.
     *
     * Strategy:
     * 1. Prefer a theme where `palette.isDark == isDark` and `meta["default"] == "true"`.
     * 2. Otherwise, pick the first theme matching the darkness preference.
     * 3. Otherwise, fall back to [defaultThemeId].
     * 4. Finally, fall back to the first available theme.
     *
     * @param isDark Whether a dark theme is preferred.
     * @return The chosen [ThemeDefinition].
     */
    private fun pickDefault(isDark: Boolean): ThemeDefinition {
        registry.families().firstOrNull { it.id == defaultThemeId }?.let {
            return if (isDark) it.dark else it.light
        }

        return registry.all().firstOrNull {
            it.palette.isDark == isDark && it.meta["default"] == "true"
        }
            ?: registry.all().firstOrNull { it.palette.isDark == isDark }
            ?: registry.get(defaultThemeId)
            ?: registry.all().first()
    }
}
