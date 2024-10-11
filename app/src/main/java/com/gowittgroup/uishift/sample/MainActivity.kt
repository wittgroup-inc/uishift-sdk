package com.gowittgroup.uishift.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.gowittgroup.uishift.ScreenRenderingEngine
import com.gowittgroup.uishift.UiShift
import com.gowittgroup.uishift.sample.sampledata.sampleConfigJson
import com.gowittgroup.uishift.sample.theme.UIShiftTheme
import com.gowittgroup.uishift.theme.lightColorScheme

/**
 *  val colorScheme = lightColorScheme(primaryButtonBackground = Color.Red)
 *  UiShift.initialize(colorScheme = colorScheme)
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIShiftTheme {
                Scaffold(modifier = Modifier.fillMaxSize())
                { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        ScreenRenderingEngine(sampleConfigJson)
                    }
                }
            }
        }
    }
}
