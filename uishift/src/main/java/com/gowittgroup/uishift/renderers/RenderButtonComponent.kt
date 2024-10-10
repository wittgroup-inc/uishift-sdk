package com.gowittgroup.uishift.renderers

import android.util.Log
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.ScreenState
import com.gowittgroup.uishift.models.Action
import com.gowittgroup.uishift.models.UIComponent
import com.gowittgroup.uishift.components.UiShiftButton

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
                    screenState.onButtonClick(action)
                }

                is Action.SubmitData -> {
                    screenState.onButtonClick(action)
                }

                is Action.ValidateField -> {
                    screenState.onButtonClick(action)
                }

                else -> {
                    Log.d("Render", "No action defined for button")
                }
            }
        })
}