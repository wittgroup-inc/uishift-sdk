package com.gowittgroup.uishift

import com.gowittgroup.uishift.models.UIComponent

fun initializeScreenState(components: List<UIComponent>, screenState: ScreenState) {
    components.forEach { component ->
        when (component) {
            is UIComponent.TextFieldComponent -> {
                screenState.updateTextFieldState(component.id, component.initialValue)
            }

            is UIComponent.CheckBoxComponent -> {
                screenState.updateCheckBoxState(component.id, component.isChecked)
            }

            is UIComponent.SliderComponent -> {
                screenState.updateSliderState(component.id, component.initialValue)
            }

            is UIComponent.ColumnComponent, is UIComponent.RowComponent -> {
                // Recursively initialize state for children components
                val children = when (component) {
                    is UIComponent.ColumnComponent -> component.children
                    is UIComponent.RowComponent -> component.children
                    else -> listOf()
                }
                initializeScreenState(children, screenState)
            }

            else -> Unit // No state to initialize for other components
        }
    }
}