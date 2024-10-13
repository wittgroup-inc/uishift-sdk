package com.gowittgroup.uishift.renderers

import android.util.Log
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.screen.ScreenIntent
import com.gowittgroup.uishift.screen.ScreenState
import com.gowittgroup.uishift.models.Action
import com.gowittgroup.uishift.models.UIComponent

private const val TAG = "RenderComponent"

@Composable
fun RenderComponent(component: UIComponent, screenState: ScreenState, onIntent: (ScreenIntent) -> Unit) {
    when (component) {
        is UIComponent.TextComponent -> RenderTextComponent(component)

        is UIComponent.ButtonComponent -> RenderButtonComponent(component) {
            when (component.onClickAction) {
                is Action.SubmitData -> onIntent(ScreenIntent.SubmitForm)
                is Action.Navigate -> onIntent(ScreenIntent.NavigateTo(component.onClickAction.destination))
                is Action.ValidateField -> {
                    // Implement field validation intent if needed
                    // onIntent(ScreenIntent.ValidateField(component.onClickAction.fieldId))
                }
                Action.NoAction -> Log.d(TAG, "No action specified for button ${component.id}")
            }
        }

        is UIComponent.ImageComponent -> RenderImageComponent(component)

        is UIComponent.ColumnComponent -> RenderColumnComponent(component, screenState, onIntent)

        is UIComponent.RowComponent -> RenderRowComponent(component, screenState, onIntent)

        is UIComponent.TextFieldComponent -> RenderTextFieldComponent(
            screenState = screenState,
            component = component,
            onValueChange = { newText -> onIntent(ScreenIntent.UpdateTextField(component.id, newText)) }
        )

        is UIComponent.CheckBoxComponent -> RenderCheckBoxComponent(
            screenState = screenState,
            component = component,
            onCheckedChange = { isChecked -> onIntent(ScreenIntent.UpdateCheckBox(component.id, isChecked)) }
        )

        is UIComponent.RadioButtonComponent -> RenderRadioButtonComponent(
            screenState = screenState,
            component = component,
            onClick = {
                val isSelected = screenState.radioButtonState.getOrDefault(component.id, component.isSelected)
                onIntent(ScreenIntent.UpdateRadioButton(component.id, !isSelected))
            }
        )

        is UIComponent.SwitchComponent -> RenderSwitchComponent(
            screenState = screenState,
            component = component,
            onCheckedChange = { isChecked -> onIntent(ScreenIntent.UpdateSwitch(component.id, isChecked)) }
        )

        is UIComponent.SliderComponent -> RenderSliderComponent(
            screenState = screenState,
            component = component,
            onValueChange = { newValue -> onIntent(ScreenIntent.UpdateSlider(component.id, newValue)) }
        )

        is UIComponent.SpacerComponent -> RenderSpacerComponent(component)

        is UIComponent.DividerComponent -> RenderDividerComponent(component)

        else -> Log.d(TAG, "Unknown component type: $component")
    }
}