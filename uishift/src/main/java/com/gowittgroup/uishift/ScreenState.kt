package com.gowittgroup.uishift

import android.util.Log
import com.gowittgroup.uishift.models.Action

class ScreenState {
    // Maintain the state of text fields, checkboxes, and sliders using a map
    val textFieldsState: MutableMap<String, String> = mutableMapOf()
    val checkBoxState: MutableMap<String, Boolean> = mutableMapOf()
    val radioButtonState: MutableMap<String, Boolean> = mutableMapOf()
    val switchState: MutableMap<String, Boolean> = mutableMapOf()
    val sliderState: MutableMap<String, Float> = mutableMapOf()

    // Function to update text field state
    fun updateTextFieldState(id: String, value: String) {
        textFieldsState[id] = value
    }

    // Function to update checkbox state
    fun updateCheckBoxState(id: String, isChecked: Boolean) {
        checkBoxState[id] = isChecked
    }

    fun updateRadioButtonState(id: String, isChecked: Boolean) {
        radioButtonState[id] = isChecked
    }

    fun updateSwitchState(id: String, isChecked: Boolean) {
        switchState[id] = isChecked
    }

    // Function to update slider state
    fun updateSliderState(id: String, value: Float) {
        sliderState[id] = value
    }

    fun onButtonClick(action: Action.SubmitData) {
        // Collect user input dynamically

        val formData = action.formData.mapValues { entry ->
            getInputValue(entry.value)
        }

        // Submit the form data
        submitForm(formData)
    }

    fun onButtonClick(action: Action.Navigate) {

        navigateTo(action.destination)
    }

    fun onButtonClick(action: Action.ValidateField) {
        // Validation logic
    }

    private fun navigateTo(destination: String) {
        // Navigation logic
    }

    private fun getInputValue(fieldId: String): String =
        textFieldsState[fieldId] ?: ""

    private fun submitForm(data: Map<String, String>) {
        // Logic to submit the form, e.g., making an API call
        Log.d("ScreenState", "Submitting form data: $data")
    }


}