package com.testingapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testingapp.databinding.ImagesHolderBinding
import com.testingapp.models.Product

class ViewPager2Adapter(
    items : ArrayList<Product>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val newList: List<Product> =
        listOf(items.last()) + items + listOf(items.first())

    inner class ItemViewHolder(val binding: ImagesHolderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(ImagesHolderBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val h = holder as ItemViewHolder
        h.binding.images.text = newList[position].title
    }


    override fun getItemCount(): Int {
        return newList.size
    }
}