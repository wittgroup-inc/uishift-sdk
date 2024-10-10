package com.gowittgroup.uishift.components

import UiShiftColorScheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.theme.ThemeConfig
import com.gowittgroup.uishift.theme.ThemeConfig.colorScheme

@Composable
fun UiShiftSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedTrackColor = colorScheme.switchOnTrackColor,
            uncheckedTrackColor = colorScheme.switchOffTrackColor,
            checkedThumbColor = colorScheme.switchThumbColor,
            uncheckedThumbColor = colorScheme.switchDisabledThumbColor
        )
    )
}