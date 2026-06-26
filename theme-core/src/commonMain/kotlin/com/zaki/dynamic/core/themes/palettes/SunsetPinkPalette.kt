package com.zaki.dynamic.core.themes.palettes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.zaki.dynamic.core.model.ThemeDefinition
import com.zaki.dynamic.core.model.ThemeFamily
import com.zaki.dynamic.core.model.ThemeId
import com.zaki.dynamic.core.themes.defaultShapes
import com.zaki.dynamic.core.themes.defaultTypography
import com.zaki.dynamic.core.toPalette

object SunsetPinkPalette {
    val primaryLight = Color(0xFF9B4061)
    val onPrimaryLight = Color(0xFFFFFFFF)
    val primaryContainerLight = Color(0xFFFFD9E2)
    val onPrimaryContainerLight = Color(0xFF3E001D)
    val secondaryLight = Color(0xFF74565F)
    val onSecondaryLight = Color(0xFFFFFFFF)
    val secondaryContainerLight = Color(0xFFFFD9E2)
    val onSecondaryContainerLight = Color(0xFF2B151C)
    val tertiaryLight = Color(0xFF7C5635)
    val onTertiaryLight = Color(0xFFFFFFFF)
    val tertiaryContainerLight = Color(0xFFFFDCC1)
    val onTertiaryContainerLight = Color(0xFF2E1500)
    val errorLight = Color(0xFFBA1A1A)
    val onErrorLight = Color(0xFFFFFFFF)
    val errorContainerLight = Color(0xFFFFDAD6)
    val onErrorContainerLight = Color(0xFF93000A)
    val backgroundLight = Color(0xFFFFFBFF)
    val onBackgroundLight = Color(0xFF201A1B)
    val surfaceLight = Color(0xFFFFFBFF)
    val onSurfaceLight = Color(0xFF201A1B)
    val surfaceVariantLight = Color(0xFFF2DDE1)
    val onSurfaceVariantLight = Color(0xFF514347)
    val outlineLight = Color(0xFF837377)
    val outlineVariantLight = Color(0xFFD5C2C6)
    val scrimLight = Color(0xFF000000)
    val inverseSurfaceLight = Color(0xFF352F30)
    val inverseOnSurfaceLight = Color(0xFFFAEEEE)
    val inversePrimaryLight = Color(0xFFFFB1C8)
    val surfaceDimLight = Color(0xFFE2D7D9)
    val surfaceBrightLight = Color(0xFFFFFBFF)
    val surfaceContainerLowestLight = Color(0xFFFFFFFF)
    val surfaceContainerLowLight = Color(0xFFFAF0F1)
    val surfaceContainerLight = Color(0xFFF7EAEC)
    val surfaceContainerHighLight = Color(0xFFF1DFE1)
    val surfaceContainerHighestLight = Color(0xFFEBD9DC)

    val primaryDark = Color(0xFFFFB1C8)
    val onPrimaryDark = Color(0xFF5F1133)
    val primaryContainerDark = Color(0xFF7D2849)
    val onPrimaryContainerDark = Color(0xFFFFD9E2)
    val secondaryDark = Color(0xFFE2BDC6)
    val onSecondaryDark = Color(0xFF422931)
    val secondaryContainerDark = Color(0xFF5B3F47)
    val onSecondaryContainerDark = Color(0xFFFFD9E2)
    val tertiaryDark = Color(0xFFEFBD94)
    val onTertiaryDark = Color(0xFF48290C)
    val tertiaryContainerDark = Color(0xFF623F20)
    val onTertiaryContainerDark = Color(0xFFFFDCC1)
    val errorDark = Color(0xFFFFB4AB)
    val onErrorDark = Color(0xFF690005)
    val errorContainerDark = Color(0xFF93000A)
    val onErrorContainerDark = Color(0xFFFFDAD6)
    val backgroundDark = Color(0xFF201A1B)
    val onBackgroundDark = Color(0xFFEBD9DC)
    val surfaceDark = Color(0xFF201A1B)
    val onSurfaceDark = Color(0xFFEBD9DC)
    val surfaceVariantDark = Color(0xFF514347)
    val onSurfaceVariantDark = Color(0xFFD5C2C6)
    val outlineDark = Color(0xFF9E8C90)
    val outlineVariantDark = Color(0xFF514347)
    val scrimDark = Color(0xFF000000)
    val inverseSurfaceDark = Color(0xFFEBD9DC)
    val inverseOnSurfaceDark = Color(0xFF352F30)
    val inversePrimaryDark = Color(0xFF9B4061)
    val surfaceDimDark = Color(0xFF201A1B)
    val surfaceBrightDark = Color(0xFF483D40)
    val surfaceContainerLowestDark = Color(0xFF140F11)
    val surfaceContainerLowDark = Color(0xFF251E20)
    val surfaceContainerDark = Color(0xFF292224)
    val surfaceContainerHighDark = Color(0xFF342D2E)
    val surfaceContainerHighestDark = Color(0xFF3F3739)

    private val lightScheme = lightColorScheme(
        primary = primaryLight,
        onPrimary = onPrimaryLight,
        primaryContainer = primaryContainerLight,
        onPrimaryContainer = onPrimaryContainerLight,
        secondary = secondaryLight,
        onSecondary = onSecondaryLight,
        secondaryContainer = secondaryContainerLight,
        onSecondaryContainer = onSecondaryContainerLight,
        tertiary = tertiaryLight,
        onTertiary = onTertiaryLight,
        tertiaryContainer = tertiaryContainerLight,
        onTertiaryContainer = onTertiaryContainerLight,
        error = errorLight,
        onError = onErrorLight,
        errorContainer = errorContainerLight,
        onErrorContainer = onErrorContainerLight,
        background = backgroundLight,
        onBackground = onBackgroundLight,
        surface = surfaceLight,
        onSurface = onSurfaceLight,
        surfaceVariant = surfaceVariantLight,
        onSurfaceVariant = onSurfaceVariantLight,
        outline = outlineLight,
        outlineVariant = outlineVariantLight,
        scrim = scrimLight,
        inverseSurface = inverseSurfaceLight,
        inverseOnSurface = inverseOnSurfaceLight,
        inversePrimary = inversePrimaryLight,
        surfaceDim = surfaceDimLight,
        surfaceBright = surfaceBrightLight,
        surfaceContainerLowest = surfaceContainerLowestLight,
        surfaceContainerLow = surfaceContainerLowLight,
        surfaceContainer = surfaceContainerLight,
        surfaceContainerHigh = surfaceContainerHighLight,
        surfaceContainerHighest = surfaceContainerHighestLight,
    )

    private val darkScheme = darkColorScheme(
        primary = primaryDark,
        onPrimary = onPrimaryDark,
        primaryContainer = primaryContainerDark,
        onPrimaryContainer = onPrimaryContainerDark,
        secondary = secondaryDark,
        onSecondary = onSecondaryDark,
        secondaryContainer = secondaryContainerDark,
        onSecondaryContainer = onSecondaryContainerDark,
        tertiary = tertiaryDark,
        onTertiary = onTertiaryDark,
        tertiaryContainer = tertiaryContainerDark,
        onTertiaryContainer = onTertiaryContainerDark,
        error = errorDark,
        onError = onErrorDark,
        errorContainer = errorContainerDark,
        onErrorContainer = onErrorContainerDark,
        background = backgroundDark,
        onBackground = onBackgroundDark,
        surface = surfaceDark,
        onSurface = onSurfaceDark,
        surfaceVariant = surfaceVariantDark,
        onSurfaceVariant = onSurfaceVariantDark,
        outline = outlineDark,
        outlineVariant = outlineVariantDark,
        scrim = scrimDark,
        inverseSurface = inverseSurfaceDark,
        inverseOnSurface = inverseOnSurfaceDark,
        inversePrimary = inversePrimaryDark,
        surfaceDim = surfaceDimDark,
        surfaceBright = surfaceBrightDark,
        surfaceContainerLowest = surfaceContainerLowestDark,
        surfaceContainerLow = surfaceContainerLowDark,
        surfaceContainer = surfaceContainerDark,
        surfaceContainerHigh = surfaceContainerHighDark,
        surfaceContainerHighest = surfaceContainerHighestDark,
    )

    private val lightTheme = ThemeDefinition(
        id = ThemeId("sunset_pink_light"),
        displayName = "Sunset Pink Light",
        palette = lightScheme.toPalette(false),
        typography = defaultTypography(),
        shapes = defaultShapes(),
        meta = mapOf("materialVersion" to "3", "default" to "true")
    )

    private val darkTheme = ThemeDefinition(
        id = ThemeId("sunset_pink_dark"),
        displayName = "Sunset Pink Dark",
        palette = darkScheme.toPalette(true),
        typography = defaultTypography(),
        shapes = defaultShapes(),
        meta = mapOf("materialVersion" to "3", "default" to "true")
    )

    const val FAMILY_ID = "sunset_pink"
    val sunsetPinkFamily = ThemeFamily(
        id = ThemeId(FAMILY_ID),
        displayName = "Sunset Pink",
        light = lightTheme,
        dark = darkTheme
    )
}
