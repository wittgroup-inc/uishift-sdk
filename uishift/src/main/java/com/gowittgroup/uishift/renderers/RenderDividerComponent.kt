package com.gowittgroup.uishift.renderers

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gowittgroup.uishift.models.components.DividerComponent
import com.gowittgroup.uishift.models.properties.Direction

@Composable
fun RenderDividerComponent(
    component: DividerComponent
) {
    RenderBaseProperties(component) { modifier ->
        if (component.direction == Direction.VERTICAL) {
            VerticalDivider(
                color = Color(android.graphics.Color.parseColor(component.color)),
                thickness = component.thickness.dp,
                modifier = modifier
            )
        } else {
            HorizontalDivider(
                color = Color(android.graphics.Color.parseColor(component.color)),
                thickness = component.thickness.dp,
                modifier = modifier
            )
        }
    }


}
