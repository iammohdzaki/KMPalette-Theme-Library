package com.zaki.dynamic.core.provider

import kotlinx.browser.window

actual class PlatformSystemThemeProvider actual constructor() : SystemThemeProvider {
     actual override fun isSystemDark(): Boolean {
         return try {
             window.matchMedia("(prefers-color-scheme: dark)").matches
         } catch (e: Throwable) {
             false
         }
     }
}