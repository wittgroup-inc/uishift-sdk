package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gowittgroup.uishift.models.Direction
import com.gowittgroup.uishift.models.UIComponent

@Composable
fun RenderDividerComponent(
    component: UIComponent.DividerComponent
) {
    if(component.direction == Direction.VERTICAL){
        VerticalDivider(
            color = Color(android.graphics.Color.parseColor(component.color)),
            thickness = component.thickness.dp,
            modifier = Modifier.fillMaxHeight()
        )
    } else {
        HorizontalDivider(
            color = Color(android.graphics.Color.parseColor(component.color)),
            thickness = component.thickness.dp,
            modifier = Modifier.fillMaxWidth()
        )
    }

}
