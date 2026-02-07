package com.zaki.dynamic.core.model

import kotlinx.serialization.Serializable

@Serializable
data class ThemeState(
    val selection: ThemeSelection,
    val resolved: ThemeDefinition // the concrete theme after applying mode
) {
    val isDark: Boolean
        get() = resolved.palette.isDark
}
