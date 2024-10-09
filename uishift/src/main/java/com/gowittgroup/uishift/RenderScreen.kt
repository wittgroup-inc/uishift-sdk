package com.gowittgroup.uishift

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.gowittgroup.uishift.models.Action
import com.gowittgroup.uishift.models.ScreenConfiguration
import com.gowittgroup.uishift.models.UIComponent
import com.gowittgroup.uishift.theme.UiShiftButton
import com.gowittgroup.uishift.theme.UiShiftText

@Composable
fun RenderScreen(screenConfig: ScreenConfiguration, screenState: ScreenState) {
    Column {
        screenConfig.components.forEach { component ->
            RenderComponent(component, screenState)
        }
    }
}

@Composable
fun RenderComponent(component: UIComponent, screenState: ScreenState) {
    when (component) {
        is UIComponent.TextComponent -> {
            UiShiftText(
                token = component.style,
                text = component.content,
                modifier = Modifier.padding(8.dp)
            )
        }

        is UIComponent.ButtonComponent -> {
            UiShiftButton(
                token = component.style,
                label = component.label,
                onClick = {
                when (val action = component.onClickAction) {
                    is Action.Navigate -> {
                        // Handle navigation
                        screenState.onButtonClick(action)
                    }

                    is Action.SubmitData -> {
                        // Handle form data submission
                        screenState.onButtonClick(action)
                    }

                    is Action.ValidateField -> {
                        // Handle field validation
                        screenState.onButtonClick(action)
                    }

                    else -> {
                        // Handle no action
                        Log.d("Render", "No action defined for button")
                    }
                }
            })
        }

        is UIComponent.ImageComponent -> {
            Image(
                painter = rememberAsyncImagePainter(component.url),
                contentDescription = component.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }

        is UIComponent.ColumnComponent -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                component.children.forEach { child ->
                    RenderComponent(child, screenState)
                }
            }
        }

        is UIComponent.RowComponent -> {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                component.children.forEach { child ->
                    RenderComponent(child, screenState)
                }
            }
        }

        is UIComponent.TextFieldComponent -> {
            var text by remember {
                mutableStateOf(
                    screenState.textFieldsState[component.id] ?: component.initialValue
                )
            }
            TextField(
                value = text,
                onValueChange = {
                    text = it
                    screenState.updateTextFieldState(component.id, it)
                },
                label = { Text(component.label) },
                placeholder = { Text(component.hint) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }

        is UIComponent.CheckBoxComponent -> {
            val isChecked = screenState.checkBoxState[component.id] ?: component.isChecked
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = {
                        screenState.updateCheckBoxState(component.id, it)
                    }
                )
                Text(component.label)
            }
        }

        is UIComponent.SliderComponent -> {
            var sliderValue by remember {
                mutableStateOf(
                    screenState.sliderState[component.id] ?: component.initialValue
                )
            }
            Column {
                Slider(
                    value = sliderValue,
                    onValueChange = { value ->
                        sliderValue = value
                        screenState.updateSliderState(component.id, value)
                    },
                    valueRange = component.min..component.max,
                    modifier = Modifier.fillMaxWidth()
                )
                Text("Selected value: ${sliderValue}")
            }
        }

        else -> Log.d("Render", "Unknown component type")
    }
}





