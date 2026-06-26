package com.zaki.dynamic.theme

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(title = "KMPalette Dynamic Theme Sample") {
        App()
    }
}
