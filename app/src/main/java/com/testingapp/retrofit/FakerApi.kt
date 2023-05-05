package com.testingapp.retrofit

import com.testingapp.models.Product
import retrofit2.Response
import retrofit2.http.GET

fun interface FakerApi {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}