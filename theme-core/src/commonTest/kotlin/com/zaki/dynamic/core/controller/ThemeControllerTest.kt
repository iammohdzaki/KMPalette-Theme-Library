package com.zaki.dynamic.core.controller

import com.zaki.dynamic.core.model.*
import com.zaki.dynamic.core.model.tokens.Palette
import com.zaki.dynamic.core.persistance.ThemeStore
import com.zaki.dynamic.core.provider.SystemThemeProvider
import com.zaki.dynamic.core.registry.DefaultThemeRegistry
import com.zaki.dynamic.core.themes.defaultShapes
import com.zaki.dynamic.core.themes.defaultTypography
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ThemeControllerTest {

    private val testPaletteLight = Palette(
        primary = 0xFF000000,
        onPrimary = 0xFFFFFFFF,
        primaryContainer = 0xFF000000,
        onPrimaryContainer = 0xFFFFFFFF,
        secondary = 0xFF000000,
        onSecondary = 0xFFFFFFFF,
        secondaryContainer = 0xFF000000,
        onSecondaryContainer = 0xFFFFFFFF,
        tertiary = 0xFF000000,
        onTertiary = 0xFFFFFFFF,
        tertiaryContainer = 0xFF000000,
        onTertiaryContainer = 0xFFFFFFFF,
        error = 0xFF000000,
        onError = 0xFFFFFFFF,
        errorContainer = 0xFF000000,
        onErrorContainer = 0xFFFFFFFF,
        background = 0xFF000000,
        onBackground = 0xFFFFFFFF,
        surface = 0xFF000000,
        onSurface = 0xFFFFFFFF,
        surfaceVariant = 0xFF000000,
        onSurfaceVariant = 0xFFFFFFFF,
        outline = 0xFF000000,
        outlineVariant = 0xFF000000,
        scrim = 0xFF000000,
        inverseSurface = 0xFF000000,
        inverseOnSurface = 0xFFFFFFFF,
        inversePrimary = 0xFF000000,
        surfaceDim = 0xFF000000,
        surfaceBright = 0xFF000000,
        surfaceContainerLowest = 0xFF000000,
        surfaceContainerLow = 0xFF000000,
        surfaceContainer = 0xFF000000,
        surfaceContainerHigh = 0xFF000000,
        surfaceContainerHighest = 0xFF000000,
        isDark = false
    )

    private val testPaletteDark = testPaletteLight.copy(isDark = true)

    private val themeLight = ThemeDefinition(
        id = ThemeId("test_light"),
        displayName = "Test Light",
        palette = testPaletteLight,
        typography = defaultTypography(),
        shapes = defaultShapes()
    )

    private val themeDark = ThemeDefinition(
        id = ThemeId("test_dark"),
        displayName = "Test Dark",
        palette = testPaletteDark,
        typography = defaultTypography(),
        shapes = defaultShapes()
    )

    private val family = ThemeFamily(
        id = ThemeId("test_family"),
        displayName = "Test Family",
        light = themeLight,
        dark = themeDark
    )

    private class FakeThemeStore : ThemeStore {
        var savedSelection: ThemeSelection? = null
        override suspend fun load(): ThemeSelection? = savedSelection
        override suspend fun save(selection: ThemeSelection) {
            savedSelection = selection
        }
    }

    private class FakeSystemThemeProvider : SystemThemeProvider {
        var isDark: Boolean = false
        override fun isSystemDark(): Boolean = isDark
    }

    private fun setupController(
        persistedSelection: ThemeSelection? = null,
        systemIsDark: Boolean = false
    ): Triple<ThemeController, FakeThemeStore, FakeSystemThemeProvider> {
        val registry = DefaultThemeRegistry().apply {
            registerFamily(family)
        }
        val store = FakeThemeStore().apply {
            savedSelection = persistedSelection
        }
        val system = FakeSystemThemeProvider().apply {
            isDark = systemIsDark
        }
        val controller = ThemeController(
            registry = registry,
            store = store,
            system = system,
            defaultThemeId = ThemeId("test_family"),
            dispatcher = kotlinx.coroutines.Dispatchers.Unconfined
        )
        return Triple(controller, store, system)
    }

    @Test
    fun testDefaultThemeResolution() {
        val (controller, _, _) = setupController(systemIsDark = false)
        val state = controller.state.value

        assertEquals(ThemeMode.SYSTEM, state.selection.mode)
        assertEquals(themeLight, state.resolved)
        assertFalse(state.isDark)
    }

    @Test
    fun testModeSwitchingToLightAndDark() {
        val (controller, _, _) = setupController(systemIsDark = false)

        controller.setMode(ThemeMode.DARK)
        assertEquals(ThemeMode.DARK, controller.state.value.selection.mode)
        assertEquals(themeDark, controller.state.value.resolved)
        assertTrue(controller.state.value.isDark)

        controller.setMode(ThemeMode.LIGHT)
        assertEquals(ThemeMode.LIGHT, controller.state.value.selection.mode)
        assertEquals(themeLight, controller.state.value.resolved)
        assertFalse(controller.state.value.isDark)
    }

    @Test
    fun testReactiveSystemDarkModeChanges() {
        val (controller, _, _) = setupController(systemIsDark = false)
        assertEquals(themeLight, controller.state.value.resolved)

        // System changes to dark
        controller.notifySystemDarkChanged(true)
        assertEquals(themeDark, controller.state.value.resolved)
        assertTrue(controller.state.value.isDark)

        // System changes back to light
        controller.notifySystemDarkChanged(false)
        assertEquals(themeLight, controller.state.value.resolved)
        assertFalse(controller.state.value.isDark)
    }

    @Test
    fun testFamilyVariantSwapOnModeSwitch() {
        val (controller, _, _) = setupController(systemIsDark = false)

        // Explicitly set the light theme variant
        controller.setExplicitTheme(ThemeId("test_light"))
        assertEquals(themeLight, controller.state.value.resolved)

        // Toggle mode to DARK. The resolved theme should swap to the dark variant of the family (test_dark)
        controller.setMode(ThemeMode.DARK)
        assertEquals(themeDark, controller.state.value.resolved)
    }
}
