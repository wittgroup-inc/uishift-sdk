package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.screen.ScreenIntent
import com.gowittgroup.uishift.screen.ScreenState
import com.gowittgroup.uishift.models.ScreenConfiguration

@Composable
fun RenderScreen(
    screenConfig: ScreenConfiguration,
    screenState: ScreenState,
    onIntent: (ScreenIntent) -> Unit
) {
    Column {
        screenConfig.components.forEach { component ->
            RenderComponent(component, screenState, onIntent)
        }
    }
}





