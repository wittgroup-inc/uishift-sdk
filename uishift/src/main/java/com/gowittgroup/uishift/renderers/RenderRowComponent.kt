package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.models.components.RowComponent
import com.gowittgroup.uishift.models.properties.toHorizontalArrangement
import com.gowittgroup.uishift.models.properties.toVerticalAlignment
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
            LazyRow(
                modifier = modifier,
                horizontalArrangement = component.childrenArrangement.toHorizontalArrangement(),
                verticalAlignment = component.childrenAlignment.toVerticalAlignment()
            ) {
                items(items = component.children, key = { it.id }) { child ->
                    RenderComponent(child, screenState, onIntent)
                }
            }
        } else {
            Row(
                modifier = modifier,
                horizontalArrangement = component.childrenArrangement.toHorizontalArrangement(),
                verticalAlignment = component.childrenAlignment.toVerticalAlignment()
            ) {
                component.children.forEach { child ->
                    RenderComponent(child, screenState, onIntent)
                }
            }
        }
    }
}