package com.gowittgroup.uishift.renderers

import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.components.UiShiftButton
import com.gowittgroup.uishift.models.components.ButtonComponent

@Composable
fun RenderButtonComponent(
    component: ButtonComponent,
    onAction: () -> Unit
) {
    RenderBaseProperties(component) { modifier ->
        UiShiftButton(
            token = component.style,
            label = component.label,
            isEnabled = component.isEnabled,
            onClick = onAction,
            modifier = modifier
        )
    }
}