package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gowittgroup.uishift.models.UIComponent
import com.gowittgroup.uishift.components.UiShiftText

@Composable
fun RenderTextComponent(component: UIComponent.TextComponent) {
    UiShiftText(
        token = component.style,
        text = component.content,
        modifier = Modifier.padding(8.dp)
    )
}