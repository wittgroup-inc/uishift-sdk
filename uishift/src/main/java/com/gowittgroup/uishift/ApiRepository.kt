package com.gowittgroup.uishift

import com.gowittgroup.uishift.models.Request

class ApiRepository(private val apiService: ApiService) {

    suspend fun performRequest(request: Request): ApiResponse<Any> {
        return when (request) {
            is Request.Command -> {
                // Make the API call using the Command's endpoint
                apiService.performCommand(request.endpoint, request)
            }
            is Request.Query -> {
                // Make the API call using the Query's endpoint
                apiService.performQuery(
                    endpoint = request.endpoint,
                    query = request.query,
                    filters = request.filters,
                    headers = request.headers
                )
            }
        }
    }
}