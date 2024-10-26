package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.models.components.RowComponent
import com.gowittgroup.uishift.screen.ScreenIntent
import com.gowittgroup.uishift.screen.ScreenState

@Composable
fun RenderRowComponent(
    component: RowComponent,
    screenState: ScreenState,
    onIntent: (ScreenIntent) -> Unit
) {
    RenderBaseProperties(component) { modifier ->
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
}