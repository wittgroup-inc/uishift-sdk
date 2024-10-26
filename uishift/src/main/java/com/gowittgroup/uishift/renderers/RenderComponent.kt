package com.gowittgroup.uishift.renderers

import android.util.Log
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.models.components.*
import com.gowittgroup.uishift.models.properties.Action
import com.gowittgroup.uishift.models.properties.ActionFlow
import com.gowittgroup.uishift.screen.ScreenIntent
import com.gowittgroup.uishift.screen.ScreenState

private const val TAG = "RenderComponent"

@Composable
fun RenderComponent(
    component: UIComponent,
    screenState: ScreenState,
    onIntent: (ScreenIntent) -> Unit
) {
    Log.d(TAG, "Rendering component: ${component::class.simpleName}")

    when (component) {
        is TextComponent -> {
            Log.d(TAG, "Rendering TextComponent: ${component.content}")
            RenderTextComponent(component)
        }

        is ButtonComponent -> {
            Log.d(TAG, "Rendering ButtonComponent with text: ${component.label}")
            RenderButtonComponent(component) {
                handleActionFlow(component.onClickAction, onIntent)
            }
        }

        is ImageComponent -> {
            Log.d(TAG, "Rendering ImageComponent with url: ${component.url}")
            RenderImageComponent(component)
        }

        is ColumnComponent -> {
            Log.d(TAG, "Rendering ColumnComponent")
            RenderColumnComponent(component, screenState, onIntent)
        }

        is RowComponent -> {
            Log.d(TAG, "Rendering RowComponent")
            RenderRowComponent(component, screenState, onIntent)
        }

        is TextFieldComponent -> {
            Log.d(TAG, "Rendering TextFieldComponent with id: ${component.id}")
            RenderTextFieldComponent(
                screenState = screenState,
                component = component,
                onValueChange = { newText ->
                    Log.d(TAG, "TextFieldComponent id: ${component.id} updated with: $newText")
                    onIntent(ScreenIntent.UpdateTextField(component.id, newText))
                }
            )
        }

        is CheckBoxComponent -> {
            Log.d(TAG, "Rendering CheckBoxComponent with id: ${component.id}")
            RenderCheckBoxComponent(
                screenState = screenState,
                component = component,
                onCheckedChange = { isChecked ->
                    Log.d(TAG, "CheckBoxComponent id: ${component.id} changed to: $isChecked")
                    onIntent(ScreenIntent.UpdateCheckBox(component.id, isChecked))
                }
            )
        }

        is RadioButtonComponent -> {
            Log.d(TAG, "Rendering RadioButtonComponent with id: ${component.id}")
            RenderRadioButtonComponent(
                screenState = screenState,
                component = component,
                onClick = {
                    val isSelected = screenState.radioButtonState.getOrDefault(
                        component.id,
                        component.isSelected
                    )
                    Log.d(
                        TAG,
                        "RadioButtonComponent id: ${component.id} changed to: ${!isSelected}"
                    )
                    onIntent(ScreenIntent.UpdateRadioButton(component.id, !isSelected))
                }
            )
        }

        is SwitchComponent -> {
            Log.d(TAG, "Rendering SwitchComponent with id: ${component.id}")
            RenderSwitchComponent(
                screenState = screenState,
                component = component,
                onCheckedChange = { isChecked ->
                    Log.d(TAG, "SwitchComponent id: ${component.id} changed to: $isChecked")
                    onIntent(ScreenIntent.UpdateSwitch(component.id, isChecked))
                }
            )
        }

        is SliderComponent -> {
            Log.d(TAG, "Rendering SliderComponent with id: ${component.id}")
            RenderSliderComponent(
                screenState = screenState,
                component = component,
                onValueChange = { newValue ->
                    Log.d(TAG, "SliderComponent id: ${component.id} changed to: $newValue")
                    onIntent(ScreenIntent.UpdateSlider(component.id, newValue))
                }
            )
        }

        is SpacerComponent -> {
            Log.d(TAG, "Rendering SpacerComponent")
            RenderSpacerComponent(component)
        }

        is DividerComponent -> {
            Log.d(TAG, "Rendering DividerComponent")
            RenderDividerComponent(component)
        }

        Unknown -> {
            Log.e(TAG, "Unknown component type: ${component::class.simpleName}")
        }
    }
}

fun handleActionFlow(
    actionFlow: ActionFlow,
    onIntent: (ScreenIntent) -> Unit
) {
    when (actionFlow) {
        is ActionFlow.Sequence -> {
            Log.d(
                TAG,
                "Handling action sequence with ${actionFlow.sequence.prefixes.size} prefixes, core, and ${actionFlow.sequence.postfixes.size} postfixes."
            )
            actionFlow.sequence.prefixes.forEach { action ->
                Log.d(TAG, "Handling action prefix: $action")
                onIntent(handleAction(action))
            }
            onIntent(handleAction(actionFlow.sequence.core))
            actionFlow.sequence.postfixes.forEach { action ->
                Log.d(TAG, "Handling action postfix: $action")
                onIntent(handleAction(action))
            }
        }

        is ActionFlow.Single -> {
            Log.d(TAG, "Handling single action: ${actionFlow.action}")
            onIntent(handleAction(actionFlow.action))
        }

        else -> {}
    }
}

fun handleAction(action: Action): ScreenIntent {
    Log.d(TAG, "Handling action: $action")
    return when (action) {
        is Action.ApiRequest -> {
            Log.d(TAG, "Action: ApiRequest with request model: ${action.requestModel}")
            ScreenIntent.ApiRequest(request = action.requestModel)
        }

        is Action.Navigate -> {
            Log.d(TAG, "Action: Navigate to ${action.destination}")
            ScreenIntent.NavigateTo(action.destination)
        }

        is Action.Validate -> {
            Log.d(TAG, "Action: Validate fieldId: ${action.fieldId}")
            ScreenIntent.Validate(action.fieldId, action.validation)
        }

        is Action.ShowError -> {
            Log.d(TAG, "Action: ShowError with message: ${action.message}")
            ScreenIntent.ShowError(action.message)
        }

        is Action.ShowSuccessMessage -> {
            Log.d(TAG, "Action: ShowSuccessMessage with message: ${action.message}")
            ScreenIntent.ShowSuccess(action.message)
        }
    }
}
