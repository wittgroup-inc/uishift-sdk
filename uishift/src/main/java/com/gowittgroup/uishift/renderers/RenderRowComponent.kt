package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gowittgroup.uishift.screen.ScreenIntent
import com.gowittgroup.uishift.screen.ScreenState
import com.gowittgroup.uishift.models.UIComponent

@Composable
fun RenderRowComponent(
    component: UIComponent.RowComponent,
    screenState: ScreenState,
    onIntent: (ScreenIntent) -> Unit
) {
    val modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
    if (component.isScrollable) {
        LazyRow(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
            items(items = component.children, key = { it.id }) { child ->
                RenderComponent(child, screenState, onIntent)
            }
        }
    } else {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            component.children.forEach { child ->
                RenderComponent(child, screenState, onIntent)
            }
        }
    }
}