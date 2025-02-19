package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.models.components.ColumnComponent
import com.gowittgroup.uishift.screen.ScreenIntent
import com.gowittgroup.uishift.screen.ScreenState

@Composable
fun RenderColumnComponent(
    component: ColumnComponent,
    screenState: ScreenState,
    onIntent: (ScreenIntent) -> Unit
) {
    RenderBaseProperties(component) { modifier ->
        if (component.isScrollable) {
            LazyColumn(modifier = modifier) {
                items(items = component.children, key = { it.id }) { child ->
                    RenderComponent(child, screenState, onIntent)
                }
            }
        } else {
            Column(
                modifier = modifier
            ) {
                component.children.forEach { child ->
                    RenderComponent(child, screenState, onIntent)
                }
            }
        }
    }

}