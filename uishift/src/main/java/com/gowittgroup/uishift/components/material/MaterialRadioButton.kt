package com.gowittgroup.uishift.components.material

import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable


@Composable
fun MaterialButton(
    selected: Boolean,
    onClick: () -> Unit
) {
    RadioButton(
        selected = selected,
        onClick = onClick
    )
}