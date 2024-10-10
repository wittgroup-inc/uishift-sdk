package com.gowittgroup.uishift.renderers

import android.util.Log
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.ScreenState
import com.gowittgroup.uishift.models.Action
import com.gowittgroup.uishift.models.UIComponent
import com.gowittgroup.uishift.theme.UiShiftButton

@Composable
fun RenderButtonComponent(
    component: UIComponent.ButtonComponent,
    screenState: ScreenState
) {
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