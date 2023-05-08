package com.testingapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testingapp.callback.ItemClickListener
import com.testingapp.databinding.RowItemBinding
import com.testingapp.models.Product

class RecyclerAdapter(
    private val items: ArrayList<Product>, private val itemClickListener: ItemClickListener

) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.products.text = items[position].title

            binding.products.setOnClickListener {
                itemClickListener.onItemClicked(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

