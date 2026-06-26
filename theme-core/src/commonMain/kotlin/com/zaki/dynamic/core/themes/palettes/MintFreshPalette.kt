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

object MintFreshPalette {
    val primaryLight = Color(0xFF006B5B)
    val onPrimaryLight = Color(0xFFFFFFFF)
    val primaryContainerLight = Color(0xFF79F8DC)
    val onPrimaryContainerLight = Color(0xFF00201A)
    val secondaryLight = Color(0xFF4A635D)
    val onSecondaryLight = Color(0xFFFFFFFF)
    val secondaryContainerLight = Color(0xFFCCE8E0)
    val onSecondaryContainerLight = Color(0xFF05201A)
    val tertiaryLight = Color(0xFF436278)
    val onTertiaryLight = Color(0xFFFFFFFF)
    val tertiaryContainerLight = Color(0xFFC7E7FF)
    val onTertiaryContainerLight = Color(0xFF001E2E)
    val errorLight = Color(0xFFBA1A1A)
    val onErrorLight = Color(0xFFFFFFFF)
    val errorContainerLight = Color(0xFFFFDAD6)
    val onErrorContainerLight = Color(0xFF93000A)
    val backgroundLight = Color(0xFFF4FAF7)
    val onBackgroundLight = Color(0xFF191C1B)
    val surfaceLight = Color(0xFFF4FAF7)
    val onSurfaceLight = Color(0xFF191C1B)
    val surfaceVariantLight = Color(0xFFDAE5E1)
    val onSurfaceVariantLight = Color(0xFF3F4946)
    val outlineLight = Color(0xFF6F7976)
    val outlineVariantLight = Color(0xFFBEC9E4)
    val scrimLight = Color(0xFF000000)
    val inverseSurfaceLight = Color(0xFF2D3130)
    val inverseOnSurfaceLight = Color(0xFFEFF1EF)
    val inversePrimaryLight = Color(0xFF5CDBBF)
    val surfaceDimLight = Color(0xFFD5DBD8)
    val surfaceBrightLight = Color(0xFFF4FAF7)
    val surfaceContainerLowestLight = Color(0xFFFFFFFF)
    val surfaceContainerLowLight = Color(0xFFEEF4F1)
    val surfaceContainerLight = Color(0xFFE8EEEC)
    val surfaceContainerHighLight = Color(0xFFE2E9E6)
    val surfaceContainerHighestLight = Color(0xFFDCE3E0)

    val primaryDark = Color(0xFF5CDBBF)
    val onPrimaryDark = Color(0xFF00372E)
    val primaryContainerDark = Color(0xFF005043)
    val onPrimaryContainerDark = Color(0xFF79F8DC)
    val secondaryDark = Color(0xFFB1CCC5)
    val onSecondaryDark = Color(0xFF1C3530)
    val secondaryContainerDark = Color(0xFF334B46)
    val onSecondaryContainerDark = Color(0xFFCCE8E0)
    val tertiaryDark = Color(0xFFA9CBE4)
    val onTertiaryDark = Color(0xFF113348)
    val tertiaryContainerDark = Color(0xFF2B4A5F)
    val onTertiaryContainerDark = Color(0xFFC7E7FF)
    val errorDark = Color(0xFFFFB4AB)
    val onErrorDark = Color(0xFF690005)
    val errorContainerDark = Color(0xFF93000A)
    val onErrorContainerDark = Color(0xFFFFDAD6)
    val backgroundDark = Color(0xFF191C1B)
    val onBackgroundDark = Color(0xFFDCE3E0)
    val surfaceDark = Color(0xFF191C1B)
    val onSurfaceDark = Color(0xFFDCE3E0)
    val surfaceVariantDark = Color(0xFF3F4946)
    val onSurfaceVariantDark = Color(0xFFBEC9E4)
    val outlineDark = Color(0xFF899390)
    val outlineVariantDark = Color(0xFF3F4946)
    val scrimDark = Color(0xFF000000)
    val inverseSurfaceDark = Color(0xFFDCE3E0)
    val inverseOnSurfaceDark = Color(0xFF2D3130)
    val inversePrimaryDark = Color(0xFF006B5B)
    val surfaceDimDark = Color(0xFF191C1B)
    val surfaceBrightDark = Color(0xFF353B39)
    val surfaceContainerLowestDark = Color(0xFF0D100F)
    val surfaceContainerLowDark = Color(0xFF1E2120)
    val surfaceContainerDark = Color(0xFF222624)
    val surfaceContainerHighDark = Color(0xFF2C302F)
    val surfaceContainerHighestDark = Color(0xFF373B39)

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
        id = ThemeId("mint_fresh_light"),
        displayName = "Mint Fresh Light",
        palette = lightScheme.toPalette(false),
        typography = defaultTypography(),
        shapes = defaultShapes(),
        meta = mapOf("materialVersion" to "3", "default" to "true")
    )

    private val darkTheme = ThemeDefinition(
        id = ThemeId("mint_fresh_dark"),
        displayName = "Mint Fresh Dark",
        palette = darkScheme.toPalette(true),
        typography = defaultTypography(),
        shapes = defaultShapes(),
        meta = mapOf("materialVersion" to "3", "default" to "true")
    )

    const val FAMILY_ID = "mint_fresh"
    val mintFreshFamily = ThemeFamily(
        id = ThemeId(FAMILY_ID),
        displayName = "Mint Fresh",
        light = lightTheme,
        dark = darkTheme
    )
}
