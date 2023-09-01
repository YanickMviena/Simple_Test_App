package com.example.simple_test_app.remote

import com.example.simple_test_app.model.AmiiboResponse
import retrofit2.Response
import retrofit2.http.GET

interface AmiiboClient {

    @GET("/api/amiibo/?name=link")
    suspend fun getAmiiboList(): Response<List<AmiiboResponse>>
}