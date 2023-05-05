package com.testingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.testingapp.adapter.RecyclerAdapter
import com.testingapp.callback.ItemClickListener
import com.testingapp.databinding.ActivityMainBinding
import com.testingapp.models.Product
import com.testingapp.viewmodels.MainViewModel
import com.testingapp.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainVewModel: MainViewModel

    private var products: ArrayList<Product> = ArrayList()

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as FakerApplication).applicationComponent.inject(this)
        mainVewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        val adapter = RecyclerAdapter(products,this)
        binding.rvHeaders.layoutManager = LinearLayoutManager(this)
        binding.rvHeaders.adapter = adapter

        mainVewModel.productsLiveData.observe(this) {

            products.clear()
            products.addAll(it)
            adapter.notifyItemRangeInserted(0,products.size)
        }

    }

    override fun onItemClicked(model: Product) {
        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        intent.putParcelableArrayListExtra("products",products)
        startActivity(intent)

    }
}