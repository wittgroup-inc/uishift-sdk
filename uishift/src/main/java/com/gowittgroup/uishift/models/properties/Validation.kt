package com.gowittgroup.uishift.models.properties

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

sealed class Validation {
    abstract val trigger: ValidationTrigger

    @JsonClass(generateAdapter = true)
    data class Text(
        val required: Boolean = false,
        val minLength: Int? = null,
        val maxLength: Int? = null,
        val regex: String? = null,
        val errorMessage: String? = null,
        override val trigger: ValidationTrigger = ValidationTrigger.ON_SUBMIT
    ) : Validation()

    @JsonClass(generateAdapter = true)
    data class Binary(
        val required: Boolean = false,
        val errorMessage: String? = null,
        override val trigger: ValidationTrigger = ValidationTrigger.ON_SUBMIT
    ) : Validation()

    @JsonClass(generateAdapter = true)
    data class Numeric(
        val required: Boolean = false,
        val minValue: Float? = null,
        val maxValue: Float? = null,
        val errorMessage: String? = null,
        override val trigger: ValidationTrigger = ValidationTrigger.ON_SUBMIT
    ) : Validation()

    @JsonClass(generateAdapter = true)
    data class Selection(
        val required: Boolean = false,
        val errorMessage: String? = null,
        override val trigger: ValidationTrigger = ValidationTrigger.ON_SUBMIT
    ) : Validation()

    @JsonClass(generateAdapter = true)
    data class None(val none: String = "None", override val trigger: ValidationTrigger = ValidationTrigger.ON_SUBMIT) : Validation()
}


enum class ValidationTrigger {
    @Json(name = "onValueChange") ON_VALUE_CHANGE,
    @Json(name = "onBlur") ON_BLUR,
    @Json(name = "onSubmit") ON_SUBMIT
}