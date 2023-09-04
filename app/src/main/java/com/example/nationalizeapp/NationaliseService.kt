package com.example.nationalizeapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NationaliseService {
    @GET("/")
    suspend fun getNationalised(@Query("name") name: String): Response<NationaliseResponse>
}
