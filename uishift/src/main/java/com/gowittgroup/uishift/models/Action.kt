package com.gowittgroup.uishift.models

import com.squareup.moshi.JsonClass

sealed class Action {
    @JsonClass(generateAdapter = true)
    data class Navigate(val destination: String) : Action()

    @JsonClass(generateAdapter = true)
    data class SubmitData(val formData: Map<String, String>) : Action() // Store dynamic key-value pairs

    @JsonClass(generateAdapter = true)
    data class ValidateField(val fieldId: String) : Action()

    data object NoAction : Action()
}