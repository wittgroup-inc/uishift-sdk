package com.gowittgroup.uishift.renderers

import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.components.UiShiftButton
import com.gowittgroup.uishift.models.UIComponent

@Composable
fun RenderButtonComponent(
    component: UIComponent.ButtonComponent,
    onAction: () -> Unit
) {
    UiShiftButton(
        token = component.style,
        label = component.label,
        isEnabled = component.isEnabled,
        onClick = onAction
    )
}