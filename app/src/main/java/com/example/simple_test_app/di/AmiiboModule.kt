package com.example.simple_test_app.di

import com.example.simple_test_app.remote.AmiiboClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AmiiboModule {

    @Provides
    @Singleton
    fun provideAmiiboService(retrofit: Retrofit): AmiiboClient {
        return retrofit.create(AmiiboClient::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.amiiboapi.com")// this should be in a config file
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}