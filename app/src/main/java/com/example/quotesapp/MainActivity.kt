package com.example.quotesapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.quotesapp.adapter.QuotesAdapter
import com.example.quotesapp.api.QuotesApiInterface
import com.example.quotesapp.api.QuotesApiServices
import com.example.quotesapp.databinding.ActivityMainBinding
import com.example.quotesapp.repository.Repository
import com.example.quotesapp.viewModel.QuotesViewModel
import com.example.quotesapp.viewModel.QuotesViewModelProvider
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var mAdapter:QuotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val quotesApiInstance=QuotesApiServices.apiInstance().create(QuotesApiInterface::class.java)
        val repository=Repository(quotesApiInstance)
        val viewModel=ViewModelProvider(this,QuotesViewModelProvider(repository))[QuotesViewModel::class.java]
        binding.shimmerLayout.startShimmer()
        val recyclerViewId=binding.quotesRecyclerView
        recyclerViewId.layoutManager=LinearLayoutManager(this)
        mAdapter=QuotesAdapter()
        recyclerViewId.adapter=mAdapter
        viewModel.getQuotes()
        viewModel.quotes.observe(this){
            it?.let {
                binding.shimmerLayout.stopShimmer()
                binding.shimmerLayout.visibility= View.GONE
                val result=it.results
                mAdapter.updateItem(result)

            }
        }
    }
}