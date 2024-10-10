package com.gowittgroup.uishift.renderers

import android.util.Log
import androidx.compose.runtime.Composable
import com.gowittgroup.uishift.ScreenState
import com.gowittgroup.uishift.models.UIComponent

@Composable
fun RenderComponent(component: UIComponent, screenState: ScreenState) {
    when (component) {
        is UIComponent.TextComponent -> RenderTextComponent(component)

        is UIComponent.ButtonComponent -> RenderButtonComponent(component, screenState)

        is UIComponent.ImageComponent -> RenderImageComponent(component)

        is UIComponent.ColumnComponent -> RenderColumnComponent(component, screenState)

        is UIComponent.RowComponent -> RenderRowComponent(component, screenState)

        is UIComponent.TextFieldComponent -> RenderTextFieldComponent(screenState, component)

        is UIComponent.CheckBoxComponent -> RenderCheckBoxComponent(screenState, component)

        is UIComponent.RadioButtonComponent -> RenderRadioButtonComponent(screenState, component)

        is UIComponent.SwitchComponent -> RenderSwitchComponent(screenState, component)

        is UIComponent.SliderComponent -> RenderSliderComponent(screenState, component)

        is UIComponent.SpacerComponent -> RenderSpacerComponent(component)

        is UIComponent.DividerComponent -> RenderDividerComponent(component)

        else -> Log.d("Render", "Unknown component type")
    }
}

