package com.zaki.dynamic.core.sheet

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.zaki.dynamic.core.LocalThemeController
import com.zaki.dynamic.core.model.ThemeId
import com.zaki.dynamic.core.model.ThemeMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemePickerBottomSheet(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    showModeToggle: Boolean = true
) {
    val controller = LocalThemeController.current.controller
    val state by controller.state.collectAsState()
    val sheetState = rememberModalBottomSheetState()

    val families = remember { controller.getAvailableThemeFamilies() }

    // Find which family the current theme belongs to
    val currentFamily = families.find { fam ->
        fam.light.id == state.resolved.id || fam.dark.id == state.resolved.id
    }

    // ✅ Compute sorted families ONCE, based on first-opened family
    val sortedFamilies = remember {
        controller.getAvailableThemeFamiliesInOrder(currentFamily?.id ?: ThemeId("standard"))
    }

    // Derive effective mode
    val effectiveMode = when {
        state.selection.mode == ThemeMode.SYSTEM -> ThemeMode.SYSTEM
        currentFamily?.dark?.id == state.resolved.id -> ThemeMode.DARK
        else -> ThemeMode.LIGHT
    }

    val scrollState = rememberScrollState()
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        modifier = modifier
    ) {
        Column(
            Modifier
                .verticalScroll(scrollState)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // --- Theme Mode Toggle ---
            if (showModeToggle) {
                Text(
                    text = "Theme Mode",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    listOf(
                        Triple("System", Icons.Default.Settings, ThemeMode.SYSTEM),
                        Triple("Light", Icons.Default.LightMode, ThemeMode.LIGHT),
                        Triple("Dark", Icons.Default.DarkMode, ThemeMode.DARK)
                    ).forEach { (label, icon, mode) ->
                        FilterChip(
                            selected = effectiveMode == mode,
                            onClick = {
                                controller.setMode(mode)

                                // 👇 keep the current family selected but switch to right variant
                                val currentFamily = families
                                    .find { fam ->
                                        fam.light.id == state.resolved.id || fam.dark.id == state.resolved.id
                                    }

                                if (currentFamily != null) {
                                    val themeToApply = when (mode) {
                                        ThemeMode.LIGHT -> currentFamily.light
                                        ThemeMode.DARK -> currentFamily.dark
                                        ThemeMode.SYSTEM -> if (controller.system.isSystemDark())
                                            currentFamily.dark else currentFamily.light
                                    }
                                    controller.setExplicitTheme(themeToApply.id)
                                }
                            },
                            label = { Text(label) },
                            leadingIcon = {
                                Icon(
                                    imageVector = icon,
                                    contentDescription = label,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        )
                    }
                }
                Spacer(Modifier.height(20.dp))
            }

            // --- Theme Families ---
            Text(
                text = "Themes",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            sortedFamilies.forEach { family ->
                val isSelectedFamily = state.resolved.id in listOf(family.light.id, family.dark.id)
                val isDarkMode = state.isDark

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            if (isSelectedFamily) MaterialTheme.colorScheme.primary.copy(alpha = 0.08f)
                            else MaterialTheme.colorScheme.surface
                        )
                        .clickable {
                            // Keep mode, just swap family
                            val themeToApply = if (isDarkMode) family.dark else family.light
                            controller.setExplicitTheme(themeToApply.id)
                        }
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DualVariantCircle(
                        lightColor = Color(family.light.palette.primary),
                        darkColor = Color(family.dark.palette.primary),
                        isSelected = isSelectedFamily,
                        isDark = isDarkMode,
                        onToggleVariant = {
                            val newMode = if (isDarkMode) ThemeMode.LIGHT else ThemeMode.DARK
                            controller.setMode(newMode)
                            val themeToApply = if (newMode == ThemeMode.DARK) family.dark else family.light
                            controller.setExplicitTheme(themeToApply.id)
                        }
                    )

                    Spacer(Modifier.width(16.dp))

                    Text(
                        text = family.displayName,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(1f)
                    )

                    if (isSelectedFamily) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Selected",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
                Spacer(Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun DualVariantCircle(
    lightColor: Color,
    darkColor: Color,
    isSelected: Boolean,
    isDark: Boolean,
    onToggleVariant: () -> Unit,
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier
            .size(40.dp)
            .clip(CircleShape)
            .clickable { onToggleVariant() }
    ) {
        // Left half = Light
        drawArc(
            color = lightColor,
            startAngle = 90f,
            sweepAngle = 180f,
            useCenter = true,
            size = size
        )
        // Right half = Dark
        drawArc(
            color = darkColor,
            startAngle = -90f,
            sweepAngle = 180f,
            useCenter = true,
            size = size
        )

        // Border highlight
        if (isSelected) {
            drawCircle(
                color = if (isDark) darkColor else lightColor,
                radius = size.minDimension / 2,
                style = Stroke(width = 4.dp.toPx())
            )
        }
    }
}