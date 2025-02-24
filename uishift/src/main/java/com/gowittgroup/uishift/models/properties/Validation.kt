package com.gowittgroup.uishift.models.properties

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

sealed class Validation {
    abstract val trigger: ValidationTrigger

    @JsonClass(generateAdapter = true)
    data class Required(
        val errorMessage: String = "This field is required",
        override val trigger: ValidationTrigger = ValidationTrigger.ON_SUBMIT
    ) : Validation()

    @JsonClass(generateAdapter = true)
    data class MinLength(
        val minLength: Int,
        val errorMessage: String = "Minimum length required is $minLength",
        override val trigger: ValidationTrigger = ValidationTrigger.ON_SUBMIT
    ) : Validation()

    @JsonClass(generateAdapter = true)
    data class MaxLength(
        val maxLength: Int,
        val errorMessage: String = "Maximum length allowed is $maxLength",
        override val trigger: ValidationTrigger = ValidationTrigger.ON_SUBMIT
    ) : Validation()

    @JsonClass(generateAdapter = true)
    data class Regex(
        val pattern: String,
        val errorMessage: String = "Invalid format",
        override val trigger: ValidationTrigger = ValidationTrigger.ON_SUBMIT
    ) : Validation()

    @JsonClass(generateAdapter = true)
    data class MinValue(
        val minValue: Float,
        val errorMessage: String = "Value must be at least $minValue",
        override val trigger: ValidationTrigger = ValidationTrigger.ON_SUBMIT
    ) : Validation()

    @JsonClass(generateAdapter = true)
    data class MaxValue(
        val maxValue: Float,
        val errorMessage: String = "Value must be at most $maxValue",
        override val trigger: ValidationTrigger = ValidationTrigger.ON_SUBMIT
    ) : Validation()

    @JsonClass(generateAdapter = true)
    data class SelectionRequired(
        val errorMessage: String = "A selection is required",
        override val trigger: ValidationTrigger = ValidationTrigger.ON_SUBMIT
    ) : Validation()

    @JsonClass(generateAdapter = true)
    data class None(
        override val trigger: ValidationTrigger = ValidationTrigger.ON_SUBMIT
    ) : Validation()
}


enum class ValidationTrigger {
    @Json(name = "onValueChange") ON_VALUE_CHANGE,
    @Json(name = "onBlur") ON_BLUR,
    @Json(name = "onSubmit") ON_SUBMIT
}