package com.gowittgroup.uishift

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse<T>(
    val success: Boolean,           // Indicates if the request was successful
    val data: T? = null,           // The actual data returned from the API (generic type)
    val message: String? = null,   // A message providing additional context or error details
    val errorCode: String? = null, // An error code if the request failed
    val timestamp: String? = null   // Optional timestamp of the response
)