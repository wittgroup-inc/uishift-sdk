package com.gowittgroup.uishift.models.properties

import com.squareup.moshi.JsonClass

sealed class Validation {

    @JsonClass(generateAdapter = true)
    data class Text(
        val required: Boolean = false,
        val minLength: Int? = null,
        val maxLength: Int? = null,
        val regex: String? = null,
        val errorMessage: String? = null
    ) : Validation()

    @JsonClass(generateAdapter = true)
    data class Binary(
        val required: Boolean = false,
        val errorMessage: String? = null
    ) : Validation()

    @JsonClass(generateAdapter = true)
    data class Numeric(
        val required: Boolean = false,
        val minValue: Float? = null,
        val maxValue: Float? = null,
        val errorMessage: String? = null
    ) : Validation()

    @JsonClass(generateAdapter = true)
    data class Selection(
        val required: Boolean = false,
        val errorMessage: String? = null
    ) : Validation()

    @JsonClass(generateAdapter = true)
    data class None(val none: String = "None") : Validation()
}
