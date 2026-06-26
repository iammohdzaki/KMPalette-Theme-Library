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

object DeepSpacePalette {
    val primaryLight = Color(0xFF2A5E8E)
    val onPrimaryLight = Color(0xFFFFFFFF)
    val primaryContainerLight = Color(0xFFD1E4FF)
    val onPrimaryContainerLight = Color(0xFF001D38)
    val secondaryLight = Color(0xFF536070)
    val onSecondaryLight = Color(0xFFFFFFFF)
    val secondaryContainerLight = Color(0xFFD6E4F7)
    val onSecondaryContainerLight = Color(0xFF0F1D2A)
    val tertiaryLight = Color(0xFF6A577B)
    val onTertiaryLight = Color(0xFFFFFFFF)
    val tertiaryContainerLight = Color(0xFFF1DBFF)
    val onTertiaryContainerLight = Color(0xFF241535)
    val errorLight = Color(0xFFBA1A1A)
    val onErrorLight = Color(0xFFFFFFFF)
    val errorContainerLight = Color(0xFFFFDAD6)
    val onErrorContainerLight = Color(0xFF93000A)
    val backgroundLight = Color(0xFFF8F9FC)
    val onBackgroundLight = Color(0xFF191C1F)
    val surfaceLight = Color(0xFFF8F9FC)
    val onSurfaceLight = Color(0xFF191C1F)
    val surfaceVariantLight = Color(0xFFDFE3E9)
    val onSurfaceVariantLight = Color(0xFF42474E)
    val outlineLight = Color(0xFF73777F)
    val outlineVariantLight = Color(0xFFC2C7CF)
    val scrimLight = Color(0xFF000000)
    val inverseSurfaceLight = Color(0xFF2E3134)
    val inverseOnSurfaceLight = Color(0xFFF0F0F3)
    val inversePrimaryLight = Color(0xFFA5C8F7)
    val surfaceDimLight = Color(0xFFD8DADE)
    val surfaceBrightLight = Color(0xFFF8F9FC)
    val surfaceContainerLowestLight = Color(0xFFFFFFFF)
    val surfaceContainerLowLight = Color(0xFFF2F4F7)
    val surfaceContainerLight = Color(0xFFECEFF2)
    val surfaceContainerHighLight = Color(0xFFE6E8EC)
    val surfaceContainerHighestLight = Color(0xFFE0E2E6)

    val primaryDark = Color(0xFFA5C8F7)
    val onPrimaryDark = Color(0xFF00325B)
    val primaryContainerDark = Color(0xFF074875)
    val onPrimaryContainerDark = Color(0xFFD1E4FF)
    val secondaryDark = Color(0xFFBAC8DB)
    val onSecondaryDark = Color(0xFF253140)
    val secondaryContainerDark = Color(0xFF3B4858)
    val onSecondaryContainerDark = Color(0xFFD6E4F7)
    val tertiaryDark = Color(0xFFD6BFE8)
    val onTertiaryDark = Color(0xFF3B2A4B)
    val tertiaryContainerDark = Color(0xFF523F62)
    val onTertiaryContainerDark = Color(0xFFF1DBFF)
    val errorDark = Color(0xFFFFB4AB)
    val onErrorDark = Color(0xFF690005)
    val errorContainerDark = Color(0xFF93000A)
    val onErrorContainerDark = Color(0xFFFFDAD6)
    val backgroundDark = Color(0xFF0E141B) // Very deep midnight background
    val onBackgroundDark = Color(0xFFE0E2E6)
    val surfaceDark = Color(0xFF0E141B)
    val onSurfaceDark = Color(0xFFE0E2E6)
    val surfaceVariantDark = Color(0xFF42474E)
    val onSurfaceVariantDark = Color(0xFFC2C7CF)
    val outlineDark = Color(0xFF8C9199)
    val outlineVariantDark = Color(0xFF42474E)
    val scrimDark = Color(0xFF000000)
    val inverseSurfaceDark = Color(0xFFE0E2E6)
    val inverseOnSurfaceDark = Color(0xFF2E3134)
    val inversePrimaryDark = Color(0xFF2A5E8E)
    val surfaceDimDark = Color(0xFF0E141B)
    val surfaceBrightDark = Color(0xFF242A32)
    val surfaceContainerLowestDark = Color(0xFF050A0F)
    val surfaceContainerLowDark = Color(0xFF131920)
    val surfaceContainerDark = Color(0xFF171E26)
    val surfaceContainerHighDark = Color(0xFF222931)
    val surfaceContainerHighestDark = Color(0xFF2C343D)

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
        id = ThemeId("deep_space_light"),
        displayName = "Deep Space Light",
        palette = lightScheme.toPalette(false),
        typography = defaultTypography(),
        shapes = defaultShapes(),
        meta = mapOf("materialVersion" to "3", "default" to "true")
    )

    private val darkTheme = ThemeDefinition(
        id = ThemeId("deep_space_dark"),
        displayName = "Deep Space Dark",
        palette = darkScheme.toPalette(true),
        typography = defaultTypography(),
        shapes = defaultShapes(),
        meta = mapOf("materialVersion" to "3", "default" to "true")
    )

    const val FAMILY_ID = "deep_space"
    val deepSpaceFamily = ThemeFamily(
        id = ThemeId(FAMILY_ID),
        displayName = "Deep Space",
        light = lightTheme,
        dark = darkTheme
    )
}
