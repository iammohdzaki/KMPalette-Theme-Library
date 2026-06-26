package com.zaki.dynamic.core.sheet

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zaki.dynamic.core.LocalThemeController
import com.zaki.dynamic.core.model.ThemeFamily
import com.zaki.dynamic.core.model.ThemeId
import com.zaki.dynamic.core.model.ThemeMode

@Composable
fun ThemePickerBottomSheet(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    showModeToggle: Boolean = true
) {
    val controller = LocalThemeController.current.controller
    val state by controller.state.collectAsState()

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

    ThemePickerContainer(
        onDismiss = onDismiss
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            // --- Header Row ---
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Appearance",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(Modifier.height(2.dp))
                    Text(
                        text = "Choose your preferred mode and colors",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                IconButton(
                    onClick = onDismiss,
                    modifier = Modifier.background(
                        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                        shape = CircleShape
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // Divider
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
            )

            // Scrollable Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f, fill = false)
                    .verticalScroll(scrollState)
                    .padding(horizontal = 24.dp)
            ) {
                Spacer(Modifier.height(20.dp))

                // --- Theme Mode Toggle ---
                if (showModeToggle) {
                    Text(
                        text = "Theme Mode",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )

                    ThemeModeSegmentControl(
                        selectedMode = effectiveMode,
                        onModeSelected = { mode ->
                            controller.setMode(mode)

                            // keep the current family selected but switch to right variant
                            val currentFam = families.find { fam ->
                                fam.light.id == state.resolved.id || fam.dark.id == state.resolved.id
                            }

                            if (currentFam != null) {
                                val themeToApply = when (mode) {
                                    ThemeMode.LIGHT -> currentFam.light
                                    ThemeMode.DARK -> currentFam.dark
                                    ThemeMode.SYSTEM -> if (controller.system.isSystemDark())
                                        currentFam.dark else currentFam.light
                                }
                                controller.setExplicitTheme(themeToApply.id)
                            }
                        }
                    )

                    Spacer(Modifier.height(24.dp))
                }

                // --- Theme Families ---
                Text(
                    text = "Theme Palettes",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                sortedFamilies.forEach { family ->
                    val isSelectedFamily = state.resolved.id in listOf(family.light.id, family.dark.id)
                    val isDarkMode = state.isDark

                    ThemeFamilyItem(
                        family = family,
                        isSelected = isSelectedFamily,
                        isDark = isDarkMode,
                        onClick = {
                            val themeToApply = if (isDarkMode) family.dark else family.light
                            controller.setExplicitTheme(themeToApply.id)
                        }
                    )
                    Spacer(Modifier.height(12.dp))
                }

                Spacer(Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun ThemeModeSegmentControl(
    selectedMode: ThemeMode,
    onModeSelected: (ThemeMode) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
            .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        val options = listOf(
            Triple("System", Icons.Default.Settings, ThemeMode.SYSTEM),
            Triple("Light", Icons.Default.LightMode, ThemeMode.LIGHT),
            Triple("Dark", Icons.Default.DarkMode, ThemeMode.DARK)
        )

        options.forEach { (label, icon, mode) ->
            val isSelected = selectedMode == mode
            val contentColor = if (isSelected) {
                MaterialTheme.colorScheme.onPrimaryContainer
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            }
            val containerColor = if (isSelected) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                Color.Transparent
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .background(containerColor)
                    .clickable { onModeSelected(mode) }
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = label,
                        tint = contentColor,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = label,
                        color = contentColor,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}

@Composable
fun ThemeFamilyItem(
    family: ThemeFamily,
    isSelected: Boolean,
    isDark: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val activeTheme = if (isDark) family.dark else family.light
    val palette = activeTheme.palette
    val primaryColor = Color(palette.primary)
    val secondaryColor = Color(palette.secondary)
    val tertiaryColor = Color(palette.tertiary)
    val surfaceColor = Color(palette.surfaceVariant)

    val cardBg = if (isSelected) {
        MaterialTheme.colorScheme.primary.copy(alpha = 0.08f)
    } else {
        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.15f)
    }

    val cardBorderColor = if (isSelected) {
        primaryColor
    } else {
        MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(cardBg)
            .border(
                width = if (isSelected) 2.dp else 1.dp,
                color = cardBorderColor,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left part: Overlapping circle colors preview representing the palette
        Row(
            horizontalArrangement = Arrangement.spacedBy((-8).dp),
            modifier = Modifier.padding(end = 12.dp)
        ) {
            val colors = listOf(primaryColor, secondaryColor, tertiaryColor, surfaceColor)
            colors.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(26.dp)
                        .background(color, shape = CircleShape)
                        .border(2.dp, cardBg, shape = CircleShape)
                )
            }
        }

        Spacer(Modifier.width(4.dp))

        // Center part: Family display name
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = family.displayName,
                style = MaterialTheme.typography.titleMedium,
                color = if (isSelected) primaryColor else MaterialTheme.colorScheme.onSurface
            )
        }

        // Right part: Selection checkmark indicator
        if (isSelected) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(primaryColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Selected",
                    tint = Color(palette.onPrimary),
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}