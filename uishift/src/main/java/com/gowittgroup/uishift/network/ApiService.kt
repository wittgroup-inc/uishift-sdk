package com.gowittgroup.uishift.network

import com.gowittgroup.uishift.models.properties.Request
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {
    @POST("{endpoint}")
    suspend fun performCommand(
        @Path("endpoint") endpoint: String,
        @Body command: Request.Command
    ): ApiResponse<Any>

    @GET("{endpoint}")
    suspend fun performQuery(
        @Path("endpoint") endpoint: String,
        @Query("query") query: String,
        @QueryMap filters: Map<String, Any>? = null,
        @HeaderMap headers: Map<String, String>? = null
    ): ApiResponse<Any>
}