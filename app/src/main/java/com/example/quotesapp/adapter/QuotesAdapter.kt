package com.example.quotesapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.quotesapp.databinding.QuotesRvSampleBinding
import com.example.quotesapp.model.Result

class QuotesAdapter : Adapter<QuotesAdapter.MyViewHolder>() {
    private val item=ArrayList<Result>()
    inner class MyViewHolder(val binding: QuotesRvSampleBinding):ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=QuotesRvSampleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount()= item.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=item[position]
        holder.binding.quotes.text=currentItem.content
        holder.binding.author.text=currentItem.author
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateItem(newItem: List<Result>) {
        item.clear()
        item.addAll(newItem)
        notifyDataSetChanged()
    }
}