package com.zaki.dynamic.core.sheet

import androidx.compose.runtime.Composable

@Composable
expect fun ThemePickerContainer(
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
)
