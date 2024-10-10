package com.gowittgroup.uishift.components.material

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gowittgroup.uishift.theme.materialTextStyle

@Composable
fun MaterialText(token: String, text: String, modifier: Modifier = Modifier) {
    val textStyle = materialTextStyle(token)
    Text(
        modifier = modifier,
        text = text,
        style = textStyle
    )
}