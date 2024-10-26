package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.models.components.SpacerComponent

@Composable
fun RenderSpacerComponent(
    component: SpacerComponent
) {
    RenderBaseProperties(component) { modifier ->
        Spacer(modifier = modifier)
    }
}
