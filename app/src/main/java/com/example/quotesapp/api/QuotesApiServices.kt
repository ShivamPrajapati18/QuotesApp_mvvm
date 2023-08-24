package com.example.quotesapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object QuotesApiServices {
    private const val BASE_URL = "https://api.quotable.io/"
    fun apiInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}//https://api.quotable.io/quotes