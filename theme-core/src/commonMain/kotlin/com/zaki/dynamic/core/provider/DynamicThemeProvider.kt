package com.zaki.dynamic.core.provider

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.zaki.dynamic.core.LocalThemeController
import com.zaki.dynamic.core.ThemeControllerHolder
import com.zaki.dynamic.core.adapter.ComposeThemeAdapter
import com.zaki.dynamic.core.controller.ThemeController

/**
 * Top-level provider for applying a dynamic theme within a Compose hierarchy.
 *
 * This composable wires together:
 * - [ThemeController] → source of theme state
 * - [ComposeThemeAdapter] → bridges your theme definition to MaterialTheme (M2, M3, etc.)
 * - [LocalThemeController] → makes the controller available via CompositionLocal
 *
 * Example:
 * ```
 * DynamicThemeProvider(
 *     controller = themeController,
 *     adapter = Material3Adapter()
 * ) {
 *     // Your app content here
 *     HomeScreen()
 * }
 * ```
 *
 * @param controller The [ThemeController] managing the current theme state.
 * @param adapter The [ComposeThemeAdapter] implementation (e.g., Material2Adapter, Material3Adapter).
 * @param typography Optional custom typography to override Material defaults.
 * @param shapes Optional custom shapes to override Material defaults.
 * @param content The UI content that should be wrapped with the applied theme.
 */
@Composable
fun DynamicThemeProvider(
    controller: ThemeController,
    adapter: ComposeThemeAdapter, // material2 or material3 (see below)
    typography: Typography? = null,
    shapes: Shapes? = null,
    content: @Composable () -> Unit
) {
    val systemDark = isSystemInDarkTheme()
    LaunchedEffect(systemDark) {
        controller.notifySystemDarkChanged(systemDark)
    }

    val state by controller.state.collectAsState()
    CompositionLocalProvider(
        LocalThemeController provides
                ThemeControllerHolder(controller)
    ) {
        adapter.MaterialTheme(state.resolved, typography, shapes) {
            content()
        }
    }
}
