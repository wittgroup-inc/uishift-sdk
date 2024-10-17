package com.gowittgroup.uishift.models

import com.squareup.moshi.JsonClass

sealed class Validation {

    // Generic validation that applies to all fields
    @JsonClass(generateAdapter = true)
    data class Base(
        val required: Boolean = false // Applies to all field types
    ) : Validation()

    // TextField-specific validation
    @JsonClass(generateAdapter = true)
    data class Text(
        val required: Boolean = false,
        val minLength: Int? = null,
        val maxLength: Int? = null,
        val regex: String? = null, // For pattern matching, like email/phone
    ) : Validation()

    // Checkbox / Switch validation
    @JsonClass(generateAdapter = true)
    data class Binary(
        val required: Boolean = false // If checkbox/switch is mandatory
    ) : Validation()

    // Slider / Numeric input validation
    @JsonClass(generateAdapter = true)
    data class Numeric(
        val required: Boolean = false,
        val minValue: Float? = null,
        val maxValue: Float? = null
    ) : Validation()

    // Selection (e.g., dropdown, radio buttons)
    @JsonClass(generateAdapter = true)
    data class Selection(
        val required: Boolean = false, // If selection is mandatory
    ) : Validation()

    data object None: Validation()
}