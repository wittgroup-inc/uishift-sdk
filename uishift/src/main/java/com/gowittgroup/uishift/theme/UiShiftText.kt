package com.gowittgroup.uishift.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun UiShiftText(token: String, text: String, modifier: Modifier = Modifier) {
    val textStyle = uiShiftTextStyle(token)
    Text(
        modifier = modifier,
        text = text,
        style = textStyle
    )
}