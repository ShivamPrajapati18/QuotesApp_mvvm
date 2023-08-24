package com.example.quotesapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.repository.Repository
import kotlinx.coroutines.launch

class QuotesViewModel(private val repository: Repository):ViewModel() {
    val quotes=repository.quotesLiveData

    fun getQuotes(){
        viewModelScope.launch {
            repository.getQuotes()
        }
    }
}