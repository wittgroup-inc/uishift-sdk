package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.gowittgroup.uishift.models.UIComponent

@Composable
fun RenderImageComponent(component: UIComponent.ImageComponent) {
    Image(
        painter = rememberAsyncImagePainter(component.url),
        contentDescription = component.description,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}