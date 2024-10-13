package com.gowittgroup.uishift.screen

data class ScreenState(
    val textFieldsState: Map<String, String> = emptyMap(),
    val checkBoxState: Map<String, Boolean> = emptyMap(),
    val radioButtonState: Map<String, Boolean> = emptyMap(),
    val switchState: Map<String, Boolean> = emptyMap(),
    val sliderState: Map<String, Float> = emptyMap(),
    val isLoading: Boolean = false,
    val error: String? = null
)