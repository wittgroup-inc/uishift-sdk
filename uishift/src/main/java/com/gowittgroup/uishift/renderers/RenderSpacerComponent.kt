package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gowittgroup.uishift.models.UIComponent

@Composable
fun RenderSpacerComponent(
    component: UIComponent.SpacerComponent
) {
    val spacerHeight = component.height?.dp ?: 16.dp
    Spacer(modifier = Modifier.height(spacerHeight))
}
