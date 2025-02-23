package com.gowittgroup.uishift.renderers

import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.components.UiShiftText
import com.gowittgroup.uishift.models.components.TextComponent


@Composable
fun RenderTextComponent(component: TextComponent) {
    RenderBaseProperties(component) { modifier ->
        UiShiftText(
            styleToken = component.style,
            text = component.content,
            modifier = modifier
        )
    }
}
