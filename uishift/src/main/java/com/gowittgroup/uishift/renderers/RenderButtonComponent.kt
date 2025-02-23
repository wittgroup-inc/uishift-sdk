package com.gowittgroup.uishift.renderers

import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.components.UiShiftButton
import com.gowittgroup.uishift.models.components.ButtonComponent

/**
 * Renders a button component with the provided properties and action.
 * @param component The button component to be rendered.
 * @param onAction The action to be performed when the button is clicked.
 */
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