package com.gowittgroup.uishift.data

import android.util.Log
import com.gowittgroup.uishift.models.properties.Request
import com.gowittgroup.uishift.network.ApiResponse
import com.gowittgroup.uishift.network.ApiService


class ApiRepository(private val apiService: ApiService? = null) {

    suspend fun performRequest(request: Request): ApiResponse<Any> {
        Log.i(
            "ApiRepository",
            "Starting API request with request type: ${request::class.simpleName}"
        )

        if(apiService == null) return ApiResponse.failure(RuntimeException("Api Service Not Available"))

        return try {
            when (request) {
                is Request.Command -> {
                    Log.d(
                        "ApiRepository",
                        "Performing Command request with endpoint: ${request.endpoint}"
                    )
                    val response = apiService.performCommand(request.endpoint, request)
                    Log.i("ApiRepository", "Command request successful")
                    response
                }

                is Request.Query -> {
                    Log.d(
                        "ApiRepository",
                        "Performing Query request with endpoint: ${request.endpoint}, query: ${request.query}, filters: ${request.filters}, headers: ${request.headers}"
                    )
                    val response = apiService.performQuery(
                        endpoint = request.endpoint,
                        query = request.query,
                        filters = request.filters,
                        headers = request.headers
                    )
                    Log.i("ApiRepository", "Query request successful")
                    response
                }

                is Request.CustomRequest -> {
                    Log.w("ApiRepository", "CustomRequest is not implemented")
                    TODO()
                }
            }
        } catch (e: Exception) {
            Log.e("ApiRepository", "API request failed: ${e.message}", e)
            ApiResponse.failure(e)
        }
    }
}