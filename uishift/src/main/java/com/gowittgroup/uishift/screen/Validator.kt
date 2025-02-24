package com.gowittgroup.uishift.screen

import com.gowittgroup.uishift.models.properties.Field
import com.gowittgroup.uishift.models.properties.Validation

object Validator {

    fun validateField(field: Field, value: Any?, validations: List<Validation>): List<String> {
        val errors = mutableListOf<String>()

        validations.forEach { validation ->
            when (validation) {
                is Validation.Required -> errors += validateRequired(field, value, validation)
                is Validation.MinLength -> errors += validateMinLength(field, value as? String, validation)
                is Validation.MaxLength -> errors += validateMaxLength(field, value as? String, validation)
                is Validation.Regex -> errors += validateRegex(field, value as? String, validation)
                is Validation.MinValue -> errors += validateMinValue(field, value as? Float, validation)
                is Validation.MaxValue -> errors += validateMaxValue(field, value as? Float, validation)
                is Validation.SelectionRequired -> errors += validateSelection(field, value as? Boolean, validation)
                is Validation.None -> {} // No validation required
            }
        }

        return errors
    }

    private fun validateRequired(field: Field, value: Any?, validation: Validation.Required): List<String> {
        return if (value == null || (value is String && value.isEmpty())) {
            listOf("${field.id}: ${validation.errorMessage}")
        } else {
            emptyList()
        }
    }

    private fun validateMinLength(field: Field, value: String?, validation: Validation.MinLength): List<String> {
        return if (value != null && value.length < validation.minLength) {
            listOf("${field.id}: ${validation.errorMessage}")
        } else {
            emptyList()
        }
    }

    private fun validateMaxLength(field: Field, value: String?, validation: Validation.MaxLength): List<String> {
        return if (value != null && value.length > validation.maxLength) {
            listOf("${field.id}: ${validation.errorMessage}")
        } else {
            emptyList()
        }
    }

    private fun validateRegex(field: Field, value: String?, validation: Validation.Regex): List<String> {
        return if (value != null && !Regex(validation.pattern).matches(value)) {
            listOf("${field.id}: ${validation.errorMessage}")
        } else {
            emptyList()
        }
    }

    private fun validateMinValue(field: Field, value: Float?, validation: Validation.MinValue): List<String> {
        return if (value != null && value < validation.minValue) {
            listOf("${field.id}: ${validation.errorMessage}")
        } else {
            emptyList()
        }
    }

    private fun validateMaxValue(field: Field, value: Float?, validation: Validation.MaxValue): List<String> {
        return if (value != null && value > validation.maxValue) {
            listOf("${field.id}: ${validation.errorMessage}")
        } else {
            emptyList()
        }
    }

    private fun validateSelection(field: Field, value: Boolean?, validation: Validation.SelectionRequired): List<String> {
        return if (value != true) {
            listOf("${field.id}: ${validation.errorMessage}")
        } else {
            emptyList()
        }
    }
}
