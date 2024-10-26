package com.gowittgroup.uishift.models

import com.squareup.moshi.JsonClass

sealed class Validation {

    // Generic validation that applies to all fields
    @JsonClass(generateAdapter = true)
    data class Base(
        val required: Boolean = false, // Applies to all field types
        val errorMessage: String? = null // Custom error message for validation failure
    ) : Validation()

    // TextField-specific validation
    @JsonClass(generateAdapter = true)
    data class Text(
        val required: Boolean = false,
        val minLength: Int? = null,
        val maxLength: Int? = null,
        val regex: String? = null, // For pattern matching, like email/phone
        val errorMessage: String? = null // Custom error message for validation failure
    ) : Validation()

    // Checkbox / Switch validation
    @JsonClass(generateAdapter = true)
    data class Binary(
        val required: Boolean = false, // If checkbox/switch is mandatory
        val errorMessage: String? = null // Custom error message for validation failure
    ) : Validation()

    // Slider / Numeric input validation
    @JsonClass(generateAdapter = true)
    data class Numeric(
        val required: Boolean = false,
        val minValue: Float? = null,
        val maxValue: Float? = null,
        val errorMessage: String? = null // Custom error message for validation failure
    ) : Validation()

    // Selection (e.g., dropdown, radio buttons)
    @JsonClass(generateAdapter = true)
    data class Selection(
        val required: Boolean = false, // If selection is mandatory
        val errorMessage: String? = null // Custom error message for validation failure
    ) : Validation()

    // For fields that do not require validation
    @JsonClass(generateAdapter = true)
    data class None(val none: String = "None") : Validation()
}
