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

/**
 * Renders a UI component with its base properties, such as padding, background, shape,
 * size, and interactions. This function ensures that the component respects visibility
 * settings and applies the appropriate styling and behavior.
 *
 * @param component The UI component to be rendered.
 * @param content A composable function that takes a [Modifier] and renders the component's content.
 */
@Composable
fun RenderBaseProperties(
    component: UIComponent,
    content: @Composable (Modifier) -> Unit
) {
    // Skip rendering if the component is not visible
    if (component.visibility == Visibility.GONE) return

    // Initialize the base modifier with padding and click interaction
    var modifier = Modifier
        .padding(
            top = component.padding.top.dp,
            bottom = component.padding.bottom.dp,
            start = component.padding.start.dp,
            end = component.padding.end.dp
        )
        .clickable(enabled = component.interactions.onClick != null) {
            component.interactions.onClick // Invoke the click action if available
        }

    // Apply background color if specified
    component.background?.color?.let { color ->
        modifier = modifier.background(color = hexToColor(color))
    }

    // Apply shape and border properties if defined
    component.shape?.let { shape ->
        val borderWidth = shape.borderWidth.dp
        val borderColor = shape.borderColor ?: return@let

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

    // Set width and height based on the given size options
    modifier = modifier
        .let { mod ->
            when (val width = component.width) {
                SizeOption.FillMaxSpace -> mod.fillMaxWidth()
                SizeOption.WrapContent -> mod.wrapContentWidth()
                is SizeOption.Fixed -> mod.width(width.value?.dp ?: 0.dp)
                null -> mod
            }
        }
        .let { mod ->
            when (val height = component.height) {
                SizeOption.FillMaxSpace -> mod.fillMaxHeight()
                SizeOption.WrapContent -> mod.wrapContentHeight()
                is SizeOption.Fixed -> mod.height(height.value?.dp ?: 0.dp)
                null -> mod.wrapContentHeight()
            }
        }

    // Render the content with the configured modifier
    content(modifier)
}

/**
 * Converts a hexadecimal color string to a [Color] object.
 *
 * @param hex The hexadecimal color string (e.g., "#RRGGBB" or "#AARRGGBB").
 * @return The corresponding [Color] object.
 */
fun hexToColor(hex: String): Color {
    return Color(android.graphics.Color.parseColor(hex))
}

/**
 * Defines an oval shape that can be used for UI components.
 */
val OvalShape: Shape = GenericShape { size, _ ->
    addOval(androidx.compose.ui.geometry.Rect(0f, 0f, size.width, size.height))
}
