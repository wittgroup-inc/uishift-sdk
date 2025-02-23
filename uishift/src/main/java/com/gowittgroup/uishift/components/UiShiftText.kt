package com.gowittgroup.uishift.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gowittgroup.uishift.constants.TextStyleToken
import com.gowittgroup.uishift.theme.uiShiftTextStyle

@Composable
fun UiShiftText(
    modifier: Modifier = Modifier,
    styleToken: String = TextStyleToken.MAIN_CONTENT,
    text: String
) {
    val textStyle = uiShiftTextStyle(styleToken)
    Text(
        modifier = modifier,
        text = text,
        style = textStyle
    )
}