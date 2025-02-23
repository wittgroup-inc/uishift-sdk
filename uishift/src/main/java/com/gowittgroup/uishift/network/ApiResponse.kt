package com.gowittgroup.uishift.network

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse<T>(
    val success: Boolean,
    val data: T? = null,
    val message: String? = null,
    val errorCode: String? = null,
    val timestamp: String? = null
) {
    companion object {
        fun <T> failure(exception: Exception, message: String? = exception.message): ApiResponse<T> {
            return ApiResponse(
                success = false,
                data = null,
                message = message,
                errorCode = "ERROR_CODE",
                timestamp = System.currentTimeMillis().toString()
            )
        }
    }
}