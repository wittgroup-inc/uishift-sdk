package com.gowittgroup.uishift

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.models.ScreenConfiguration
import com.gowittgroup.uishift.parser.ConfigParser

@Composable
fun ScreenRenderingEngine(jsonConfiguration: String) {
    // Moshi setup

    // Parse JSON configuration
    val screenConfiguration: ScreenConfiguration? = ConfigParser().parse(jsonConfiguration)

    // Initialize ScreenState
    val screenState = ScreenState()
    initializeScreenState(screenConfiguration?.components ?: listOf(), screenState)

    // Render the screen
    screenConfiguration?.let {
        RenderScreen(it, screenState)
    } ?: Text("No screen configuration available")
}