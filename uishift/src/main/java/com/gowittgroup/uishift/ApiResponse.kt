package com.gowittgroup.uishift

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse<T>(
    val success: Boolean,            // Indicates if the request was successful
    val data: T? = null,             // Generic data returned from the API
    val message: String? = null,     // Additional context or error details
    val errorCode: String? = null,   // Error code if the request failed
    val timestamp: String? = null    // Optional timestamp of the response
) {
    companion object {
        // Factory function to create a failure response
        fun <T> failure(exception: Exception, message: String? = exception.message): ApiResponse<T> {
            return ApiResponse(
                success = false,
                data = null,
                message = message,
                errorCode = "ERROR_CODE", // Customize error code if needed
                timestamp = System.currentTimeMillis().toString()
            )
        }
    }
}