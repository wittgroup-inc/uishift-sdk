package com.gowittgroup.uishift.screen

sealed class ScreenIntent {
    data class UpdateTextField(val id: String, val value: String) : ScreenIntent()
    data class UpdateCheckBox(val id: String, val isChecked: Boolean) : ScreenIntent()
    data class UpdateRadioButton(val id: String, val isChecked: Boolean) : ScreenIntent()
    data class UpdateSwitch(val id: String, val isChecked: Boolean) : ScreenIntent()
    data class UpdateSlider(val id: String, val value: Float) : ScreenIntent()
    object SubmitForm : ScreenIntent()
    data class NavigateTo(val destination: String) : ScreenIntent()
}