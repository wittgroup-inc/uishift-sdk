package com.gowittgroup.uishift.components

import UiShiftColorScheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.theme.ThemeConfig

@Composable
fun UiShiftSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    colorScheme: UiShiftColorScheme = ThemeConfig.colorScheme // Accept the color scheme as a parameter
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedTrackColor = colorScheme.switchOnTrackColor, // Track color when ON from color scheme
            uncheckedTrackColor = colorScheme.switchOffTrackColor, // Track color when OFF from color scheme
            checkedThumbColor = colorScheme.switchThumbColor, // Thumb color when ON from color scheme
            uncheckedThumbColor = colorScheme.switchDisabledThumbColor // Thumb color when OFF from color scheme
        )
    )
}