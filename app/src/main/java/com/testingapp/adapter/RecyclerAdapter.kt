package com.testingapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testingapp.callback.ItemClickListener
import com.testingapp.databinding.RowItemBinding
import com.testingapp.models.Product

class RecyclerAdapter (
    private val items : ArrayList<Product>
    , private val itemClickListener: ItemClickListener

    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ItemViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(RowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val h = holder as ItemViewHolder
        h.binding.products.text = items[position].title

        h.binding.products.setOnClickListener {
            itemClickListener.onItemClicked(items[position])
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

}

