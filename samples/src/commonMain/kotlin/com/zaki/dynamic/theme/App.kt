package com.zaki.dynamic.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.russhwolf.settings.Settings
import com.zaki.dynamic.core.LocalThemeController
import com.zaki.dynamic.core.adapter.Material3Adapter
import com.zaki.dynamic.core.controller.ThemeController
import com.zaki.dynamic.core.model.ThemeId
import com.zaki.dynamic.core.model.ThemeMode
import com.zaki.dynamic.core.provider.DynamicThemeProvider
import com.zaki.dynamic.core.provider.PlatformSystemThemeProvider
import com.zaki.dynamic.core.registry.DefaultThemeRegistryFactory
import com.zaki.dynamic.core.sheet.ThemePickerBottomSheet
import com.zaki.dynamic.core.themes.palettes.RedFlamePalette
import com.zaki.dynamic.theme.persistance.SettingsThemeStore
import com.zaki.dynamic.theme.theme.DefaultPalette.defaultFamily
import com.zaki.dynamic.theme.theme.SansTypography

@Composable
fun App() {
    val controller = remember {
        val registry = DefaultThemeRegistryFactory.createWithDefaults()
        registry.registerFamily(defaultFamily)
        ThemeController(
            registry = registry,
            store = SettingsThemeStore(Settings()),
            system = PlatformSystemThemeProvider(),
            defaultThemeId = ThemeId(RedFlamePalette.FAMILY_ID)
        )
    }

    DynamicThemeProvider(
        controller = controller,
        adapter = Material3Adapter(),
        typography = SansTypography()
    ) {
        AppScaffold()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppScaffold() {
    var showSheet by remember { mutableStateOf(false) }
    val controller = LocalThemeController.current.controller
    val state by controller.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Dynamic Theme",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                actions = {
                    val isDark = state.isDark
                    IconButton(onClick = {
                        controller.setMode(if (isDark) ThemeMode.LIGHT else ThemeMode.DARK)
                    }) {
                        Icon(
                            if (isDark) Icons.Default.DarkMode else Icons.Default.LightMode,
                            contentDescription = "Toggle theme"
                        )
                    }
                    IconButton(onClick = { showSheet = true }) {
                        Icon(Icons.Default.ColorLens, contentDescription = "Pick theme")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // ✅ Theme Info Card
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text("Current Theme", style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(4.dp))
                    Text(state.resolved.displayName, style = MaterialTheme.typography.bodyLarge)
                }
            }

            // ✅ Buttons Showcase
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            ) {
                Column(
                    Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text("Buttons", style = MaterialTheme.typography.titleMedium)

                    Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Text("Filled Button")
                    }

                    OutlinedButton(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Text("Outlined Button")
                    }

                    TextButton(onClick = {}) {
                        Text("Text Button")
                    }
                }
            }

            // ✅ Inputs Showcase
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            ) {
                Column(
                    Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text("Inputs", style = MaterialTheme.typography.titleMedium)

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Name") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Email") },
                        leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            // ✅ Toggles Showcase
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            ) {
                Column(
                    Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text("Toggles", style = MaterialTheme.typography.titleMedium)

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = true, onCheckedChange = {})
                        Spacer(Modifier.width(8.dp))
                        Text("Checkbox Example")
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Switch(checked = false, onCheckedChange = {})
                        Spacer(Modifier.width(8.dp))
                        Text("Switch Example")
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = true, onClick = {})
                        Spacer(Modifier.width(8.dp))
                        Text("Radio Button Example")
                    }
                }
            }

            // ✅ Slider & Progress
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            ) {
                Column(
                    Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text("Sliders & Progress", style = MaterialTheme.typography.titleMedium)

                    Slider(value = 0.5f, onValueChange = {})
                    LinearProgressIndicator(
                        progress = { 0.7f },
                        modifier = Modifier.fillMaxWidth(),
                        color = ProgressIndicatorDefaults.linearColor,
                        trackColor = ProgressIndicatorDefaults.linearTrackColor,
                        strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
                    )
                    CircularProgressIndicator()
                }
            }
        }

        if (showSheet) {
            ThemePickerBottomSheet(onDismiss = { showSheet = false })
        }
    }
}
