package com.zaki.dynamic.core.registry

import com.zaki.dynamic.core.model.ThemeDefinition
import com.zaki.dynamic.core.model.ThemeFamily
import com.zaki.dynamic.core.model.ThemeId
import com.zaki.dynamic.core.model.tokens.Palette
import com.zaki.dynamic.core.themes.defaultShapes
import com.zaki.dynamic.core.themes.defaultTypography
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ThemeRegistryTest {

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

    @Test
    fun testRegisterSingleTheme() {
        val registry = DefaultThemeRegistry()
        registry.register(themeLight)

        assertEquals(1, registry.all().size)
        assertEquals(themeLight, registry.get(ThemeId("test_light")))
    }

    @Test
    fun testRegisterThemeFamily() {
        val registry = DefaultThemeRegistry()
        registry.registerFamily(family)

        // Both light & dark should be registered as separate themes
        assertEquals(2, registry.all().size)
        assertEquals(themeLight, registry.get(ThemeId("test_light")))
        assertEquals(themeDark, registry.get(ThemeId("test_dark")))

        // The family should also be registered
        assertEquals(1, registry.families().size)
        assertEquals(family, registry.families().first())
    }

    @Test
    fun testRegisterAllAndOrder() {
        val registry = DefaultThemeRegistry()
        registry.registerAll(listOf(themeLight, themeDark))

        val all = registry.all()
        assertEquals(2, all.size)
        assertEquals(themeLight, all[0])
        assertEquals(themeDark, all[1])
    }

    @Test
    fun testGetNonExistentThemeReturnsNull() {
        val registry = DefaultThemeRegistry()
        assertNull(registry.get(ThemeId("does_not_exist")))
    }
}
