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

object LavenderPurplePalette {
    val primaryLight = Color(0xFF6F43C0)
    val onPrimaryLight = Color(0xFFFFFFFF)
    val primaryContainerLight = Color(0xFFECDCFF)
    val onPrimaryContainerLight = Color(0xFF24005A)
    val secondaryLight = Color(0xFF625B71)
    val onSecondaryLight = Color(0xFFFFFFFF)
    val secondaryContainerLight = Color(0xFFE8DEF8)
    val onSecondaryContainerLight = Color(0xFF1E192B)
    val tertiaryLight = Color(0xFF7E5264)
    val onTertiaryLight = Color(0xFFFFFFFF)
    val tertiaryContainerLight = Color(0xFFFFD9E6)
    val onTertiaryContainerLight = Color(0xFF311021)
    val errorLight = Color(0xFFBA1A1A)
    val onErrorLight = Color(0xFFFFFFFF)
    val errorContainerLight = Color(0xFFFFDAD6)
    val onErrorContainerLight = Color(0xFF93000A)
    val backgroundLight = Color(0xFFFFFBFF)
    val onBackgroundLight = Color(0xFF1C1B1E)
    val surfaceLight = Color(0xFFFFFBFF)
    val onSurfaceLight = Color(0xFF1C1B1E)
    val surfaceVariantLight = Color(0xFFE7E0EC)
    val onSurfaceVariantLight = Color(0xFF49454F)
    val outlineLight = Color(0xFF7A757F)
    val outlineVariantLight = Color(0xFFCAC4D0)
    val scrimLight = Color(0xFF000000)
    val inverseSurfaceLight = Color(0xFF313033)
    val inverseOnSurfaceLight = Color(0xFFF4F0F4)
    val inversePrimaryLight = Color(0xFFD7BAFF)
    val surfaceDimLight = Color(0xFFDDD8DE)
    val surfaceBrightLight = Color(0xFFFFFBFF)
    val surfaceContainerLowestLight = Color(0xFFFFFFFF)
    val surfaceContainerLowLight = Color(0xFFF8F2FA)
    val surfaceContainerLight = Color(0xFFF2ECF4)
    val surfaceContainerHighLight = Color(0xFFECE6EE)
    val surfaceContainerHighestLight = Color(0xFFE6E1E8)

    val primaryDark = Color(0xFFD7BAFF)
    val onPrimaryDark = Color(0xFF3F008D)
    val primaryContainerDark = Color(0xFF5727A7)
    val onPrimaryContainerDark = Color(0xFFECDCFF)
    val secondaryDark = Color(0xFFCCC2DC)
    val onSecondaryDark = Color(0xFF332D41)
    val secondaryContainerDark = Color(0xFF4A4458)
    val onSecondaryContainerDark = Color(0xFFE8DEF8)
    val tertiaryDark = Color(0xFFF0B7CE)
    val onTertiaryDark = Color(0xFF4A2536)
    val tertiaryContainerDark = Color(0xFF643B4C)
    val onTertiaryContainerDark = Color(0xFFFFD9E6)
    val errorDark = Color(0xFFFFB4AB)
    val onErrorDark = Color(0xFF690005)
    val errorContainerDark = Color(0xFF93000A)
    val onErrorContainerDark = Color(0xFFFFDAD6)
    val backgroundDark = Color(0xFF1C1B1E)
    val onBackgroundDark = Color(0xFFE6E1E8)
    val surfaceDark = Color(0xFF1C1B1E)
    val onSurfaceDark = Color(0xFFE6E1E8)
    val surfaceVariantDark = Color(0xFF49454F)
    val onSurfaceVariantDark = Color(0xFFCAC4D0)
    val outlineDark = Color(0xFF948F99)
    val outlineVariantDark = Color(0xFF49454F)
    val scrimDark = Color(0xFF000000)
    val inverseSurfaceDark = Color(0xFFE6E1E8)
    val inverseOnSurfaceDark = Color(0xFF313033)
    val inversePrimaryDark = Color(0xFF6F43C0)
    val surfaceDimDark = Color(0xFF1C1B1E)
    val surfaceBrightDark = Color(0xFF444246)
    val surfaceContainerLowestDark = Color(0xFF0F0D11)
    val surfaceContainerLowDark = Color(0xFF201E22)
    val surfaceContainerDark = Color(0xFF242226)
    val surfaceContainerHighDark = Color(0xFF2E2C30)
    val surfaceContainerHighestDark = Color(0xFF39373B)

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
        id = ThemeId("lavender_purple_light"),
        displayName = "Lavender Purple Light",
        palette = lightScheme.toPalette(false),
        typography = defaultTypography(),
        shapes = defaultShapes(),
        meta = mapOf("materialVersion" to "3", "default" to "true")
    )

    private val darkTheme = ThemeDefinition(
        id = ThemeId("lavender_purple_dark"),
        displayName = "Lavender Purple Dark",
        palette = darkScheme.toPalette(true),
        typography = defaultTypography(),
        shapes = defaultShapes(),
        meta = mapOf("materialVersion" to "3", "default" to "true")
    )

    const val FAMILY_ID = "lavender_purple"
    val lavenderPurpleFamily = ThemeFamily(
        id = ThemeId(FAMILY_ID),
        displayName = "Lavender Purple",
        light = lightTheme,
        dark = darkTheme
    )
}
