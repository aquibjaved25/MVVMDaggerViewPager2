package com.testingapp.viewmodels

import androidx.lifecycle.ViewModel
import com.testingapp.models.Product
import com.testingapp.repository.ProductRepository
import javax.inject.Inject

class MainViewModel2 @Inject constructor(private val repository: ProductRepository): ViewModel(){

    fun getProducts():ArrayList<Product>{
        val products:ArrayList<Product> = ArrayList()

        products.add(Product("","",0,"",0.0,"hello1"))
        products.add(Product("","",0,"",0.0,"hello2"))
        products.add(Product("","",0,"",0.0,"hello3"))
        products.add(Product("","",0,"",0.0,"hello4"))
        products.add(Product("","",0,"",0.0,"hello5"))
        products.add(Product("","",0,"",0.0,"hello6"))

        return products
    }

}