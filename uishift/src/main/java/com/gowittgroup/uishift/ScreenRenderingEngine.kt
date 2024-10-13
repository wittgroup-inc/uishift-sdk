package com.gowittgroup.uishift

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gowittgroup.uishift.renderers.RenderScreen
import com.gowittgroup.uishift.screen.ScreenConfigState
import com.gowittgroup.uishift.screen.ScreenViewModel

@Composable
fun ScreenRenderingEngine(viewModel: ScreenViewModel) {


    val screenConfigState by viewModel.screenConfigState.collectAsState()

    when (screenConfigState) {
        is ScreenConfigState.Loading -> {
            // Show a loading indicator
            CircularProgressIndicator()
        }

        is ScreenConfigState.Success -> {
            // If the configuration is successfully loaded, render the screen
            val config = (screenConfigState as ScreenConfigState.Success).config
            RenderScreen(
                screenConfig = config,
                screenState = viewModel.uiState.collectAsState().value,
                onIntent = viewModel::processIntent
            )
        }

        is ScreenConfigState.Error -> {
            // Show an error message and a retry button
            val errorMessage = (screenConfigState as ScreenConfigState.Error).message
            ErrorScreen(errorMessage, onRetryClick = { viewModel.retryFetchingConfig() })
        }
    }
}

@Composable
fun ErrorScreen(errorMessage: String, onRetryClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Error: $errorMessage", color = Color.Red, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onRetryClick) {
            Text("Retry")
        }
    }
}