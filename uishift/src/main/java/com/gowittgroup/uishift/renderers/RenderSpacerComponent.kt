package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Box
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
    Spacer(modifier = Modifier.height(component.height.dp))
}
