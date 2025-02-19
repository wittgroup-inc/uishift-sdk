package com.gowittgroup.uishift.models.properties

import com.squareup.moshi.JsonClass

sealed class Action {

    @JsonClass(generateAdapter = true)
    data class Navigate(
        val destination: String,
        val params: Map<String, Any>? = null
    ) : Action()

    @JsonClass(generateAdapter = true)
    data class Validate(
        val field: Field,
        val validation: Validation,
        val onValidationFail: Action? = null
    ) : Action()

    @JsonClass(generateAdapter = true)
    data class ApiRequest(
        val requestModel: Request,
        val retryCount: Int = 3,
        val onRetry: Action? = null,
        val onSuccess: Action? = null,
        val onFailure: Action? = null
    ) : Action()

    @JsonClass(generateAdapter = true)
    data class ShowError(
        val message: String,
        val prefixes: List<Action> = emptyList(),
        val postfixes: List<Action> = emptyList(),
        val logError: Boolean = true
    ) : Action()

    @JsonClass(generateAdapter = true)
    data class ShowSuccessMessage(
        val message: String,
        val prefixes: List<Action> = emptyList(),
        val postfixes: List<Action> = emptyList(),
        val logSuccess: Boolean = true
    ) : Action()
}


data class Field(
    val id: String,
    val type: String,
    val metadata: Map<String, Any>? = null
)

@JsonClass(generateAdapter = true)
data class ActionSequence(
    val core: Action,
    val prefixes: List<Action> = emptyList(),
    val postfixes: List<Action> = emptyList(),
    val onError: Action? = null
)

sealed class ActionFlow {

    @JsonClass(generateAdapter = true)
    data class Single(val action: Action) : ActionFlow()

    @JsonClass(generateAdapter = true)
    data class Sequence(val sequence: ActionSequence) : ActionFlow()
}

sealed class Request {

    abstract val endpoint: String

    @JsonClass(generateAdapter = true)
    data class Command(
        val action: String,
        val parameters: Map<String, Any>? = null,
        val headers: Map<String, String>? = null,
        override val endpoint: String,
        val retries: Int = 3,
        val timeout: Long = 3000L
    ) : Request()

    @JsonClass(generateAdapter = true)
    data class Query(
        val query: String,
        val filters: Map<String, Any>? = null,
        val headers: Map<String, String>? = null,
        override val endpoint: String,
        val retries: Int = 3,
        val timeout: Long = 3000L
    ) : Request()

    @JsonClass(generateAdapter = true)
    data class CustomRequest(
        val customType: String,
        val payload: Map<String, Any>,
        override val endpoint: String,
        val retries: Int = 3,
        val timeout: Long = 3000L
    ) : Request()
}

