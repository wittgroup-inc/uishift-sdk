package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.gowittgroup.uishift.models.components.ImageComponent
import com.gowittgroup.uishift.models.properties.ScaleType
import com.gowittgroup.uishift.models.properties.common.SizeOption

// TODO: Need to revisit this class for scaling issue
@Composable
fun RenderImageComponent(component: ImageComponent) {

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    val contentScale = when (component.scaleType) {
        ScaleType.FIT -> ContentScale.Fit
        ScaleType.CROP -> ContentScale.Crop
        ScaleType.FILL_BOUNDS -> ContentScale.FillBounds
    }

    // Assuming screenWidth and screenHeight are defined as Dp
    val calculatedWidth = when {
        component.width is SizeOption.Fixed -> component.width.value?.dp ?: 0.dp
        component.height is SizeOption.Fixed -> (component.height.value ?: 0).dp * (16 / 9f).coerceAtMost(screenWidth.value)
        else -> screenWidth // Use full screen width if width is null and height is not fixed
    }

    val calculatedHeight = when {
        component.height is SizeOption.Fixed -> component.height.value?.dp ?: 0.dp
        component.width is SizeOption.Fixed -> (component.width.value ?: 0).dp / (16 / 9f).coerceAtMost(screenHeight.value)
        else -> screenHeight // Use full screen height if height is null and width is not fixed
    }

    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data(component.url)
        .size(Size.ORIGINAL)
        .crossfade(true)
        .build()

    RenderBaseProperties(component) { modifier ->
        Image(
            painter = rememberAsyncImagePainter(imageRequest),
            contentDescription = component.description,
            modifier = modifier
                .width(calculatedWidth)
                .height(calculatedHeight), // Use the calculated height instead of a fixed value
            contentScale = contentScale
        )
    }

}


