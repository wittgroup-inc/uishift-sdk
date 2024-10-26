package com.gowittgroup.uishift

import com.gowittgroup.uishift.models.Request
import android.util.Log


class ApiRepository(private val apiService: ApiService) {

    suspend fun performRequest(request: Request): ApiResponse<Any> {
        Log.i(
            "ApiRepository",
            "Starting API request with request type: ${request::class.simpleName}"
        )

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