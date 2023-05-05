package com.testingapp.callback

import com.testingapp.models.Product

fun interface ItemClickListener {
fun onItemClicked(model: Product)
}