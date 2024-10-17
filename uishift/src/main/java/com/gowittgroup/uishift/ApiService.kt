package com.gowittgroup.uishift

import com.gowittgroup.uishift.models.Request
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {
    @POST("{endpoint}") // Use a dynamic endpoint for commands
    suspend fun performCommand(
        @Path("endpoint") endpoint: String, // Path parameter for the endpoint
        @Body command: Request.Command // The command object to send in the body
    ): ApiResponse<Any>

    @GET("{endpoint}") // Use a dynamic endpoint for queries
    suspend fun performQuery(
        @Path("endpoint") endpoint: String, // Path parameter for the endpoint
        @Query("query") query: String, // The query string as a query parameter
        @QueryMap filters: Map<String, Any>? = null, // Optional filters as query parameters
        @HeaderMap headers: Map<String, String>? = null // Optional headers
    ): ApiResponse<Any>
}