package com.gowittgroup.uishift.models

import com.squareup.moshi.JsonClass

// Base class for all actions
sealed class Action {

    @JsonClass(generateAdapter = true)
    data class Navigate(
        val destination: String,
        val params: Map<String, Any>? = null // Added parameters to support dynamic navigation
    ) : Action()

    @JsonClass(generateAdapter = true)
    data class Validate(
        val fieldId: Field,
        val validation: Validation,
        val onValidationFail: Action? = null // Action to perform if validation fails
    ) : Action()

    @JsonClass(generateAdapter = true)
    data class ApiRequest(
        val requestModel: Request,
        val retryCount: Int = 3, // Default retries
        val onRetry: Action? = null, // Action to perform on retry
        val onSuccess: Action? = null, // Action to perform on success
        val onFailure: Action? = null // Action to perform on failure
    ) : Action()

    @JsonClass(generateAdapter = true)
    data class ShowError(
        val message: String,
        val prefixes: List<Action> = emptyList(), // Actions before showing error
        val postfixes: List<Action> = emptyList(), // Actions after showing error
        val logError: Boolean = true // Optional flag to log error
    ) : Action()

    @JsonClass(generateAdapter = true)
    data class ShowSuccessMessage(
        val message: String,
        val prefixes: List<Action> = emptyList(), // Actions before showing success message
        val postfixes: List<Action> = emptyList(), // Actions after showing success message
        val logSuccess: Boolean = true // Optional flag to log success
    ) : Action()
}

// Field model, extended to allow more flexibility
data class Field(
    val id: String,
    val type: String, // Changed to enum for better type safety
    val metadata: Map<String, Any>? = null // Optional metadata to allow field extensibility
)


// ActionSequence defines a flow of actions
@JsonClass(generateAdapter = true)
data class ActionSequence(
    val core: Action, // The main/core action
    val prefixes: List<Action> = emptyList(), // Actions to execute before the core action
    val postfixes: List<Action> = emptyList(), // Actions to execute after the core action
    val onError: Action? = null // Centralized error handler for the sequence
)

// ActionFlow can represent either a single action or a sequence of actions
sealed class ActionFlow {

    @JsonClass(generateAdapter = true)
    data class Single(val action: Action) : ActionFlow()

    @JsonClass(generateAdapter = true)
    data class Sequence(val sequence: ActionSequence) : ActionFlow()
}

// Abstract class for requests to support various API patterns
sealed class Request {

    abstract val endpoint: String

    @JsonClass(generateAdapter = true)
    data class Command(
        val action: String, // Name of the command/action
        val parameters: Map<String, Any>? = null, // Dynamic parameters for the command
        val headers: Map<String, String>? = null, // Optional headers for the command
        override val endpoint: String,
        val retries: Int = 3, // Retries with default value
        val timeout: Long = 3000L // Timeout in milliseconds, added for better control
    ) : Request()

    @JsonClass(generateAdapter = true)
    data class Query(
        val query: String, // The query string to be executed
        val filters: Map<String, Any>? = null, // Optional filters for the query
        val headers: Map<String, String>? = null, // Optional headers for the query
        override val endpoint: String,
        val retries: Int = 3, // Retries with default value
        val timeout: Long = 3000L // Timeout in milliseconds, added for better control
    ) : Request()

    // Custom request to allow SDK users to define their own request structure
    @JsonClass(generateAdapter = true)
    data class CustomRequest(
        val customType: String, // Type of the custom request
        val payload: Map<String, Any>, // Payload for custom request
        override val endpoint: String,
        val retries: Int = 3, // Retries with default value
        val timeout: Long = 3000L // Timeout in milliseconds, added for better control
    ) : Request()
}

// Example error logging and handling methods for robustness
fun logError(action: Action, error: Throwable) {
    // Log the error for debugging
    println("Error occurred during action: $action, error: ${error.message}")
}

fun logSuccess(action: Action) {
    // Log the success for auditing
    println("Action completed successfully: $action")
}

