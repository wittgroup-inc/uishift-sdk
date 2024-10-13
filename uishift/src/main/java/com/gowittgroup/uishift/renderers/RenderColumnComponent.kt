package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gowittgroup.uishift.screen.ScreenIntent
import com.gowittgroup.uishift.screen.ScreenState
import com.gowittgroup.uishift.models.UIComponent

@Composable
fun RenderColumnComponent(
    component: UIComponent.ColumnComponent,
    screenState: ScreenState,
    onIntent: (ScreenIntent) -> Unit
) {
    val modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)

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