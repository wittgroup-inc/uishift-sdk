package com.gowittgroup.uishift.screen

import com.gowittgroup.uishift.models.properties.Field
import com.gowittgroup.uishift.models.properties.Validation

object Validator {

    fun validateField(field: Field, value: Any?, validations: List<Validation>): List<String> {
        val errors = mutableListOf<String>()

        validations.forEach { validation ->
            when (validation) {
                is Validation.Text -> errors += validateText(field, value as? String, validation)
                is Validation.Binary -> errors += validateBoolean(field, value as? Boolean, validation)
                is Validation.Numeric -> errors += validateNumeric(field, value as? Float, validation)
                is Validation.Selection -> errors += validateSelection(field, value as? Boolean, validation)
                is Validation.None -> {} // No validation required
            }
        }

        return errors
    }

    private fun validateText(field: Field, value: String?, validation: Validation.Text): List<String> {
        val errors = mutableListOf<String>()

        if (validation.required && value.isNullOrEmpty()) {
            errors.add("${field.id}: ${validation.errorMessage ?: "This field is required."}")
        }
        if (!value.isNullOrEmpty()) {
            if (validation.minLength != null && value.length < validation.minLength) {
                errors.add("${field.id}: ${validation.errorMessage ?: "Minimum length is ${validation.minLength}."}")
            }
            if (validation.maxLength != null && value.length > validation.maxLength) {
                errors.add("${field.id}: ${validation.errorMessage ?: "Maximum length is ${validation.maxLength}."}")
            }
            if (validation.regex != null && !Regex(validation.regex).matches(value)) {
                errors.add("${field.id}: ${validation.errorMessage ?: "Invalid format."}")
            }
        }
        return errors
    }

    private fun validateBoolean(field: Field, value: Boolean?, validation: Validation.Binary): List<String> {
        return if (validation.required && value != true) {
            listOf("${field.id}: ${validation.errorMessage ?: "This field must be checked."}")
        } else {
            emptyList()
        }
    }

    private fun validateNumeric(field: Field, value: Float?, validation: Validation.Numeric): List<String> {
        val errors = mutableListOf<String>()

        if (validation.required && value == null) {
            errors.add("${field.id}: ${validation.errorMessage ?: "This field is required."}")
        }
        if (value != null) {
            if (validation.minValue != null && value < validation.minValue) {
                errors.add("${field.id}: ${validation.errorMessage ?: "Value must be at least ${validation.minValue}."}")
            }
            if (validation.maxValue != null && value > validation.maxValue) {
                errors.add("${field.id}: ${validation.errorMessage ?: "Value must not exceed ${validation.maxValue}."}")
            }
        }
        return errors
    }

    private fun validateSelection(field: Field, value: Boolean?, validation: Validation.Selection): List<String> {
        return if (validation.required && value != true) {
            listOf("${field.id}: ${validation.errorMessage ?: "Selection is required."}")
        } else {
            emptyList()
        }
    }
}
