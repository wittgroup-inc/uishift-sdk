package com.gowittgroup.uishift.renderers

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.ScreenState
import com.gowittgroup.uishift.models.ScreenConfiguration

@Composable
fun RenderScreen(screenConfig: ScreenConfiguration, screenState: ScreenState) {
    Column {
        screenConfig.components.forEach { component ->
            RenderComponent(component, screenState)
        }
    }
}





