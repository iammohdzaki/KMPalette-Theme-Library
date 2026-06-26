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

object GoldenAmberPalette {
    val primaryLight = Color(0xFF825500)
    val onPrimaryLight = Color(0xFFFFFFFF)
    val primaryContainerLight = Color(0xFFFFDDB3)
    val onPrimaryContainerLight = Color(0xFF291800)
    val secondaryLight = Color(0xFF705D49)
    val onSecondaryLight = Color(0xFFFFFFFF)
    val secondaryContainerLight = Color(0xFFFBE1C8)
    val onSecondaryContainerLight = Color(0xFF291B0B)
    val tertiaryLight = Color(0xFF586437)
    val onTertiaryLight = Color(0xFFFFFFFF)
    val tertiaryContainerLight = Color(0xFFDCEDA5)
    val onTertiaryContainerLight = Color(0xFF161E00)
    val errorLight = Color(0xFFBA1A1A)
    val onErrorLight = Color(0xFFFFFFFF)
    val errorContainerLight = Color(0xFFFFDAD6)
    val onErrorContainerLight = Color(0xFF93000A)
    val backgroundLight = Color(0xFFFFFBFF)
    val onBackgroundLight = Color(0xFF1F1B16)
    val surfaceLight = Color(0xFFFFFBFF)
    val onSurfaceLight = Color(0xFF1F1B16)
    val surfaceVariantLight = Color(0xFFF0E0CF)
    val onSurfaceVariantLight = Color(0xFF4F4539)
    val outlineLight = Color(0xFF817567)
    val outlineVariantLight = Color(0xFFD3C4B4)
    val scrimLight = Color(0xFF000000)
    val inverseSurfaceLight = Color(0xFF34302A)
    val inverseOnSurfaceLight = Color(0xFFF9EFE7)
    val inversePrimaryLight = Color(0xFFFFB951)
    val surfaceDimLight = Color(0xFFE6DEC5)
    val surfaceBrightLight = Color(0xFFFFFBFF)
    val surfaceContainerLowestLight = Color(0xFFFFFFFF)
    val surfaceContainerLowLight = Color(0xFFF8F0E5)
    val surfaceContainerLight = Color(0xFFF2EADC)
    val surfaceContainerHighLight = Color(0xFFEBE4D5)
    val surfaceContainerHighestLight = Color(0xFFE5DECE)

    val primaryDark = Color(0xFFFFB951)
    val onPrimaryDark = Color(0xFF452B00)
    val primaryContainerDark = Color(0xFF633F00)
    val onPrimaryContainerDark = Color(0xFFFFDDB3)
    val secondaryDark = Color(0xFFDEC5AE)
    val onSecondaryDark = Color(0xFF3E2F20)
    val secondaryContainerDark = Color(0xFF564534)
    val onSecondaryContainerDark = Color(0xFFFBE1C8)
    val tertiaryDark = Color(0xFFC0D18C)
    val onTertiaryDark = Color(0xFF2B3410)
    val tertiaryContainerDark = Color(0xFF414B21)
    val onTertiaryContainerDark = Color(0xFFDCEDA5)
    val errorDark = Color(0xFFFFB4AB)
    val onErrorDark = Color(0xFF690005)
    val errorContainerDark = Color(0xFF93000A)
    val onErrorContainerDark = Color(0xFFFFDAD6)
    val backgroundDark = Color(0xFF1F1B16)
    val onBackgroundDark = Color(0xFFE5DECE)
    val surfaceDark = Color(0xFF1F1B16)
    val onSurfaceDark = Color(0xFFE5DECE)
    val surfaceVariantDark = Color(0xFF4F4539)
    val onSurfaceVariantDark = Color(0xFFD3C4B4)
    val outlineDark = Color(0xFF9B8F80)
    val outlineVariantDark = Color(0xFF4F4539)
    val scrimDark = Color(0xFF000000)
    val inverseSurfaceDark = Color(0xFFE5DECE)
    val inverseOnSurfaceDark = Color(0xFF34302A)
    val inversePrimaryDark = Color(0xFF825500)
    val surfaceDimDark = Color(0xFF1F1B16)
    val surfaceBrightDark = Color(0xFF443F39)
    val surfaceContainerLowestDark = Color(0xFF14100B)
    val surfaceContainerLowDark = Color(0xFF241F1A)
    val surfaceContainerDark = Color(0xFF28231E)
    val surfaceContainerHighDark = Color(0xFF332D28)
    val surfaceContainerHighestDark = Color(0xFF3F3832)

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
        id = ThemeId("golden_amber_light"),
        displayName = "Golden Amber Light",
        palette = lightScheme.toPalette(false),
        typography = defaultTypography(),
        shapes = defaultShapes(),
        meta = mapOf("materialVersion" to "3", "default" to "true")
    )

    private val darkTheme = ThemeDefinition(
        id = ThemeId("golden_amber_dark"),
        displayName = "Golden Amber Dark",
        palette = darkScheme.toPalette(true),
        typography = defaultTypography(),
        shapes = defaultShapes(),
        meta = mapOf("materialVersion" to "3", "default" to "true")
    )

    const val FAMILY_ID = "golden_amber"
    val goldenAmberFamily = ThemeFamily(
        id = ThemeId(FAMILY_ID),
        displayName = "Golden Amber",
        light = lightTheme,
        dark = darkTheme
    )
}
