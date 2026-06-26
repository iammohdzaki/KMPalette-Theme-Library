package com.zaki.dynamic.core.provider

import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

actual class PlatformSystemThemeProvider actual constructor() : SystemThemeProvider {
    actual override fun isSystemDark(): Boolean {
        val style = UIScreen.mainScreen.traitCollection.userInterfaceStyle
        return when (style) {
            UIUserInterfaceStyle.UIUserInterfaceStyleDark -> true
            UIUserInterfaceStyle.UIUserInterfaceStyleLight -> false
            UIUserInterfaceStyle.UIUserInterfaceStyleUnspecified -> false
            else -> false
        }
    }
}