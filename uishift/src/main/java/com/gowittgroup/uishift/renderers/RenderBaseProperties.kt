package com.gowittgroup.uishift.renderers


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.gowittgroup.uishift.models.components.UIComponent
import com.gowittgroup.uishift.models.properties.common.SizeOption
import com.gowittgroup.uishift.models.properties.common.Visibility
import com.gowittgroup.uishift.models.properties.common.shape.ShapeType

@Composable
fun RenderBaseProperties(
    component: UIComponent,
    content: @Composable (Modifier) -> Unit
) {
    // 1. Apply visibility logic
    if (component.visibility == Visibility.GONE) return // Skip rendering if the component is gone

    // 2. Prepare the base modifier
    var modifier = Modifier
        .padding(
            top = component.padding.top.dp,
            bottom = component.padding.bottom.dp,
            start = component.padding.start.dp,
            end = component.padding.end.dp
        )
        .clickable(enabled = component.interactions.onClick != null) {
            component.interactions.onClick // Call the click interaction if it exists
        }

    // 3. Handle background color only if it's not null
    component.background?.color?.let { color ->
        modifier = modifier.background(color = hexToColor(color))
    }

    // 4. Handle shape and border properties only if shape is not null
    component.shape?.let { shape ->
        val borderWidth = shape.borderWidth.dp // Exit if borderWidth is null
        val borderColor = shape.borderColor ?: return@let // Exit if borderColor is null

        modifier = modifier.border(
            width = borderWidth,
            color = hexToColor(borderColor),
            shape = when (shape.type) {
                ShapeType.CIRCLE -> CircleShape
                ShapeType.OVAL -> OvalShape
                ShapeType.ROUNDED_RECTANGLE -> RoundedCornerShape(
                    shape.cornerRadius?.dp ?: return@let
                )

                else -> RectangleShape
            }
        )
    }

    // 5. Handle width and height only if they are not null
    modifier = modifier
        .let { mod ->
            when (val width = component.width) {
                SizeOption.FillMaxSpace -> mod.fillMaxWidth() // Fill max width
                SizeOption.WrapContent -> mod.wrapContentWidth() // Wrap content width
                is SizeOption.Fixed -> {
                    mod.width(width.value?.dp ?: 0.dp)
                }

                null -> mod // No width option provided
            }
        }
        .let { mod ->
            when (val height = component.height) {
                SizeOption.FillMaxSpace -> mod.fillMaxHeight() // Fill max height
                SizeOption.WrapContent -> mod.wrapContentHeight() // Wrap content height
                is SizeOption.Fixed -> mod.height(
                    height.value?.dp ?: 0.dp
                )

                null -> mod.wrapContentHeight() // No height option provided
            }
        }

    // 6. Render the specific content of the child component with the prepared modifier
    content(modifier)
}

fun hexToColor(hex: String): Color {
    return Color(android.graphics.Color.parseColor(hex))
}

val OvalShape: Shape = GenericShape { size, _ ->
    addOval(androidx.compose.ui.geometry.Rect(0f, 0f, size.width, size.height))
}