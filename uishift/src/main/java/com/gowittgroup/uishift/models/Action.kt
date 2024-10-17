package com.gowittgroup.uishift.models
import com.squareup.moshi.JsonClass

sealed class Action {

    @JsonClass(generateAdapter = true)
    data class Navigate(
        val destination: String,
    ) : Action()

    @JsonClass(generateAdapter = true)
    data class Validate(
        val fieldId: Field,
        val validation: Validation
    ) : Action()

    @JsonClass(generateAdapter = true)
    data class ApiRequest(
        val requestModel: Request,
        val retryCount: Int
    ) : Action()

    @JsonClass(generateAdapter = true)
    data class ShowError(
        val message: String,
        val prefixes: List<Action> = emptyList(),  // Actions before showing error
        val postfixes: List<Action> = emptyList()  // Actions after showing error
    ) : Action()

    @JsonClass(generateAdapter = true)
    data class ShowSuccessMessage(
        val message: String,
        val prefixes: List<Action> = emptyList(),  // Actions before showing success message
        val postfixes: List<Action> = emptyList()  // Actions after showing success message
    ) : Action()
}

data class Field(
    val id: String,
    val type: String
)

// ActionSequence class defines the action flow (prefixes, core, postfixes)
@JsonClass(generateAdapter = true)
data class ActionSequence(
    val core: Action,                             // The main/core action
    val prefixes: List<Action> = emptyList(),     // Actions to execute before the core action
    val postfixes: List<Action> = emptyList()     // Actions to execute after the core action
)

// Define ActionOrSequence sealed class
sealed class ActionFlow {

    // Single action case
    @JsonClass(generateAdapter = true)
    data class Single(val action: Action) : ActionFlow()

    // Action sequence case
    @JsonClass(generateAdapter = true)
    data class Sequence(val sequence: ActionSequence) : ActionFlow()
}

sealed class Request {

    abstract val endpoint: String

    @JsonClass(generateAdapter = true)
    data class Command(
        val action: String, // Name of the command/action
        val parameters: Map<String, Any>? = null, // Dynamic parameters for the command
        val headers: Map<String, String>? = null, // Optional headers for the command
        override val endpoint: String

    ) : Request()

    @JsonClass(generateAdapter = true)
    data class Query(
        val query: String, // The query string to be executed
        val filters: Map<String, Any>? = null, // Optional filters for the query
        val headers: Map<String, String>? = null, // Optional headers for the query
        override val endpoint: String
    ) : Request()
}


