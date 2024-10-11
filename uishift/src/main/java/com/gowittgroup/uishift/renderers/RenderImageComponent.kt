package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.gowittgroup.uishift.models.ScaleType
import com.gowittgroup.uishift.models.UIComponent

// TODO: Need to revisit this class for scaling issue
@Composable
fun RenderImageComponent(component: UIComponent.ImageComponent) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    val contentScale = when (component.scaleType) {
        ScaleType.FIT -> ContentScale.Fit
        ScaleType.CROP -> ContentScale.Crop
        ScaleType.FILL_BOUNDS -> ContentScale.FillBounds
    }

    val calculatedWidth = when {
        component.width != null -> component.width.dp
        component.height != null -> component.height.dp * (16 / 9f).coerceAtMost(screenWidth.value)
        else -> screenWidth
    }

    val calculatedHeight = when {
        component.height != null -> component.height.dp
        component.width != null -> component.width.dp / (16 / 9f).coerceAtMost(screenHeight.value)
        else -> screenHeight
    }

    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data(component.url)
        .size(Size.ORIGINAL)
        .crossfade(true)
        .build()

    Image(
        painter = rememberAsyncImagePainter(imageRequest),
        contentDescription = component.description,
        modifier = Modifier
            .width(calculatedWidth)
            .height(calculatedHeight), // Use the calculated height instead of a fixed value
        contentScale = contentScale
    )
}


