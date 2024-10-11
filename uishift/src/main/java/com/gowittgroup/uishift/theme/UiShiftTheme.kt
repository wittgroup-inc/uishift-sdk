package com.gowittgroup.uishift.theme

import UiShiftTypography
import androidx.compose.runtime.Composable

@Composable
fun UiShiftTheme(
    typography: UiShiftTypography = ThemeConfig.typography,
    colorScheme: UiShiftColorScheme = ThemeConfig.colorScheme,
    content: @Composable () -> Unit
) {
    content()
}