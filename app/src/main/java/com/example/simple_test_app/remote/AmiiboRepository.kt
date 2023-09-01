package com.example.simple_test_app.remote

import com.example.simple_test_app.model.AmiiboResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AmiiboRepository @Inject constructor(
    private val amiiboClient: AmiiboClient
) {

    suspend fun fetchData(): Response<List<AmiiboResponse>> {
        // here I would like to add some error handling
        return withContext(Dispatchers.IO) {
            amiiboClient.getAmiiboList()
        }
    }
}