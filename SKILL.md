---
name: kmpalette-integration-skill
description: Guides the integration of the KMPalette theme library (version 0.0.6) inside a Kotlin Multiplatform project.
---

# 🌌 KMPalette AI Integration Skill (v0.0.6)

This skill provides precise guidance and recipes for integrating the **KMPalette** (`KMP-Dynamic-Theme-Library`) dynamic theme manager inside a Kotlin Multiplatform (KMP) codebase using Jetpack Compose Multiplatform.

---

## 📦 Dependency Setup

Add the library to your `commonMain` dependencies block in your project's Gradle configuration:

```kotlin
// build.gradle.kts (Shared Module)
commonMain.dependencies {
    implementation("io.github.iammohdzaki.kmpalette:theme-core:0.0.6")
}
```

---

## 📐 Platform Requirements & Features

- **Android**: Target & Compile SDK `36` (Min SDK `24`).
- **iOS**: Target platforms `iosX64()`, `iosArm64()`, `iosSimulatorArm64()`. Utilizes a custom thread-safe `PlatformLock` (actualized via `NSRecursiveLock`) to prevent race conditions during dynamic asset loading.
- **Desktop (JVM)**: Full JVM compatibility running Java 17+.
- **WasmJS (Web)**: Uses browser media query checks (`window.matchMedia("(prefers-color-scheme: dark)")`) to support reactive system dark mode changes. Requires `<canvas id="ComposeTarget"></canvas>` in the root `index.html`.

---

## 🚀 Core API Reference

### 1. ThemeDefinition
Represents a single theme color palette (Light or Dark).
```kotlin
val lightOcean = ThemeDefinition(
    id = ThemeId("ocean_light"),
    displayName = "Ocean Light",
    palette = Palette(...) // Custom Material 3 color mapping
)
```

### 2. ThemeFamily
Groups a light and dark theme definition under a unified name.
```kotlin
val oceanFamily = ThemeFamily(
    displayName = "Ocean Blue",
    light = lightOcean,
    dark = darkOcean
)
```

### 3. ThemeRegistry
Collects all registered families. Map operations are protected with an internal lock to ensure thread safety.
```kotlin
val registry = DefaultThemeRegistryFactory.createWithDefaults()
registry.registerFamily(oceanFamily)
```

### 4. ThemeController
Central controller managing theme mode, explicit theme settings, reactive system theme observer, and local persistence.
```kotlin
val controller = ThemeController(
    registry = registry,
    store = SettingsThemeStore(Settings()), // Custom implementation of ThemeStore
    system = PlatformSystemThemeProvider(), // Expect/Actual system provider
    defaultThemeId = ThemeId("tree_brown")
)
```

---

## 🎨 Jetpack Compose Integration

Wrap your application entry point with `DynamicThemeProvider` using a `ComposeThemeAdapter` (like `Material3Adapter`):

```kotlin
// App.kt
@Composable
fun App() {
    val controller = remember {
        val registry = DefaultThemeRegistryFactory.createWithDefaults()
        ThemeController(
            registry = registry,
            store = SettingsThemeStore(Settings()),
            system = PlatformSystemThemeProvider(),
            defaultThemeId = ThemeId("ocean_blue")
        )
    }

    DynamicThemeProvider(
        controller = controller,
        adapter = Material3Adapter(),
        typography = AppTypography() // Optional custom typography
    ) {
        AppScaffold()
    }
}
```

---

## 📱 Theme Picker UI Components

### 1. Dialog / Bottom Sheet Picker
Exposes a responsive popup sheet/dialog container that adapts based on the target platform (Bottom Sheet on mobiles, Centered Dialog on desktop & web):

```kotlin
var showThemePicker by remember { mutableStateOf(false) }

if (showThemePicker) {
    ThemePickerBottomSheet(
        onDismiss = { showThemePicker = false },
        showModeToggle = true
    )
}
```

### 2. Standalone Inline Content (For Custom Pages)
Exposes the core list content directly for developers to embed inside custom screens (like inline inside a settings screen):

```kotlin
// Renders the segmented mode selector and palette cards directly in your layout
ThemePickerContent(
    showModeToggle = true,
    showHeader = false
)
```

---

## 💡 Code Generator Helper Recipes

When generating custom code for KMPalette integration:
1. **Convert standard Compose ColorScheme**: Use `ColorScheme.toThemeDefinition(...)` to dynamically convert color schemes.
2. **Build Theme Families**: Use `createThemeFamily(id, displayName, lightScheme, darkScheme)` helper extensions to package a light and dark scheme pair.
3. **Observing Theme Change**: Access active theme state reactively inside Composables:
   ```kotlin
   val controller = LocalThemeController.current.controller
   val state by controller.state.collectAsState()
   val isDark = state.isDark
   val activeTheme = state.resolved
   ```
