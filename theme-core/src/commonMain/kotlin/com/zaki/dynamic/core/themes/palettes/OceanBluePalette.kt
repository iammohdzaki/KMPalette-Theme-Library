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

object OceanBluePalette {
    val primaryLight = Color(0xFF006493)
    val onPrimaryLight = Color(0xFFFFFFFF)
    val primaryContainerLight = Color(0xFFCBE6FF)
    val onPrimaryContainerLight = Color(0xFF001E30)
    val secondaryLight = Color(0xFF50606E)
    val onSecondaryLight = Color(0xFFFFFFFF)
    val secondaryContainerLight = Color(0xFFD3E5F5)
    val onSecondaryContainerLight = Color(0xFF0C1D29)
    val tertiaryLight = Color(0xFF655675)
    val onTertiaryLight = Color(0xFFFFFFFF)
    val tertiaryContainerLight = Color(0xFFECDCFF)
    val onTertiaryContainerLight = Color(0xFF201430)
    val errorLight = Color(0xFFBA1A1A)
    val onErrorLight = Color(0xFFFFFFFF)
    val errorContainerLight = Color(0xFFFFDAD6)
    val onErrorContainerLight = Color(0xFF93000A)
    val backgroundLight = Color(0xFFFCFCFF)
    val onBackgroundLight = Color(0xFF1A1C1E)
    val surfaceLight = Color(0xFFFCFCFF)
    val onSurfaceLight = Color(0xFF1A1C1E)
    val surfaceVariantLight = Color(0xFFDEE3EB)
    val onSurfaceVariantLight = Color(0xFF42474E)
    val outlineLight = Color(0xFF73777F)
    val outlineVariantLight = Color(0xFFC2C7CF)
    val scrimLight = Color(0xFF000000)
    val inverseSurfaceLight = Color(0xFF2F3033)
    val inverseOnSurfaceLight = Color(0xFFF1F0F4)
    val inversePrimaryLight = Color(0xFF8BCEFF)
    val surfaceDimLight = Color(0xFFDADAE0)
    val surfaceBrightLight = Color(0xFFFCFCFF)
    val surfaceContainerLowestLight = Color(0xFFFFFFFF)
    val surfaceContainerLowLight = Color(0xFFF3F3FA)
    val surfaceContainerLight = Color(0xFFEDEDF4)
    val surfaceContainerHighLight = Color(0xFFE7E7EE)
    val surfaceContainerHighestLight = Color(0xFFE1E2E9)

    val primaryDark = Color(0xFF8BCEFF)
    val onPrimaryDark = Color(0xFF00344F)
    val primaryContainerDark = Color(0xFF004B70)
    val onPrimaryContainerDark = Color(0xFFCBE6FF)
    val secondaryDark = Color(0xFFB7C9D9)
    val onSecondaryDark = Color(0xFF22323F)
    val secondaryContainerDark = Color(0xFF394956)
    val onSecondaryContainerDark = Color(0xFFD3E5F5)
    val tertiaryDark = Color(0xFFCFC0E2)
    val onTertiaryDark = Color(0xFF362945)
    val tertiaryContainerDark = Color(0xFF4D3F5C)
    val onTertiaryContainerDark = Color(0xFFECDCFF)
    val errorDark = Color(0xFFFFB4AB)
    val onErrorDark = Color(0xFF690005)
    val errorContainerDark = Color(0xFF93000A)
    val onErrorContainerDark = Color(0xFFFFDAD6)
    val backgroundDark = Color(0xFF1A1C1E)
    val onBackgroundDark = Color(0xFFE1E2E9)
    val surfaceDark = Color(0xFF1A1C1E)
    val onSurfaceDark = Color(0xFFE1E2E9)
    val surfaceVariantDark = Color(0xFF42474E)
    val onSurfaceVariantDark = Color(0xFFC2C7CF)
    val outlineDark = Color(0xFF8C9199)
    val outlineVariantDark = Color(0xFF42474E)
    val scrimDark = Color(0xFF000000)
    val inverseSurfaceDark = Color(0xFFE1E2E9)
    val inverseOnSurfaceDark = Color(0xFF2F3033)
    val inversePrimaryDark = Color(0xFF006493)
    val surfaceDimDark = Color(0xFF1A1C1E)
    val surfaceBrightDark = Color(0xFF38393C)
    val surfaceContainerLowestDark = Color(0xFF0E1113)
    val surfaceContainerLowDark = Color(0xFF1E2022)
    val surfaceContainerDark = Color(0xFF222427)
    val surfaceContainerHighDark = Color(0xFF2C2F32)
    val surfaceContainerHighestDark = Color(0xFF373A3D)

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
        id = ThemeId("ocean_blue_light"),
        displayName = "Ocean Blue Light",
        palette = lightScheme.toPalette(false),
        typography = defaultTypography(),
        shapes = defaultShapes(),
        meta = mapOf("materialVersion" to "3", "default" to "true")
    )

    private val darkTheme = ThemeDefinition(
        id = ThemeId("ocean_blue_dark"),
        displayName = "Ocean Blue Dark",
        palette = darkScheme.toPalette(true),
        typography = defaultTypography(),
        shapes = defaultShapes(),
        meta = mapOf("materialVersion" to "3", "default" to "true")
    )

    const val FAMILY_ID = "ocean_blue"
    val oceanBlueFamily = ThemeFamily(
        id = ThemeId(FAMILY_ID),
        displayName = "Ocean Blue",
        light = lightTheme,
        dark = darkTheme
    )
}
