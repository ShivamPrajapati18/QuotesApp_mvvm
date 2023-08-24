package com.example.quotesapp.api

import com.example.quotesapp.model.QuotesData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApiInterface {
    @GET("quotes")
    suspend fun getQuotes():Response<QuotesData>
}