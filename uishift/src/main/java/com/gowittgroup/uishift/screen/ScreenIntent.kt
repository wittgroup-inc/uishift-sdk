package com.gowittgroup.uishift.screen

import com.gowittgroup.uishift.models.Field
import com.gowittgroup.uishift.models.Request
import com.gowittgroup.uishift.models.Validation

sealed class ScreenIntent {
    data class UpdateTextField(val id: String, val value: String) : ScreenIntent()
    data class UpdateCheckBox(val id: String, val isChecked: Boolean) : ScreenIntent()
    data class UpdateRadioButton(val id: String, val isChecked: Boolean) : ScreenIntent()
    data class UpdateSwitch(val id: String, val isChecked: Boolean) : ScreenIntent()
    data class UpdateSlider(val id: String, val value: Float) : ScreenIntent()
    data class SubmitForm(val fields: Map<String, String>) : ScreenIntent()
    data class NavigateTo(val destination: String) : ScreenIntent()
    data class ApiRequest(val request: Request) : ScreenIntent()
    data class Validate(val field: Field, val validation: Validation) : ScreenIntent()
    data class ShowError(val field: String) : ScreenIntent()
    data class ShowSuccess(val message: String): ScreenIntent()
}