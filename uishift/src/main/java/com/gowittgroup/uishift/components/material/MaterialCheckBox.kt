package com.gowittgroup.uishift.components.material

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable

@Composable
fun MaterialCheckBox(checked: Boolean = false, onCheckedChange: (Boolean) -> Unit) {
    Checkbox(
        checked = checked,
        onCheckedChange = onCheckedChange
    )
}