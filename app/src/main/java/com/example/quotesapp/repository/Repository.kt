package com.example.quotesapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotesapp.api.QuotesApiInterface
import com.example.quotesapp.model.QuotesData

class Repository(val quotesApiInterface: QuotesApiInterface) {
    private val _liveData=MutableLiveData<QuotesData>()
    val quotesLiveData:LiveData<QuotesData>
        get() = _liveData
    suspend fun getQuotes(){
        val result=quotesApiInterface.getQuotes()
        result.body()?.let {
            _liveData.postValue(it)
        }
    }
}