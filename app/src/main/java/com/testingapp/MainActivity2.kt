package com.testingapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.testingapp.adapter.ViewPager2Adapter
import com.testingapp.databinding.ActivityMain2Binding
import com.testingapp.models.Product
import com.testingapp.viewmodels.MainViewModel2
import com.testingapp.viewmodels.MainViewModelFactory
import javax.inject.Inject


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private var listSize: Int = 0

    private lateinit var mainVewModel2: MainViewModel2

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as FakerApplication).applicationComponent.inject(this)
        mainVewModel2 = ViewModelProvider(this, mainViewModelFactory)[MainViewModel2::class.java]

        //mainVewModel2.getProducts()
       val products: ArrayList<Product> = intent.getParcelableArrayListExtra("products")!!
        Log.e("productSize",""+products.size)
        listSize = products.size+2


        val adapter = ViewPager2Adapter(products)
        binding.viewpager.adapter = adapter
        binding.viewpager.currentItem = 1

        // function for registering a callback to update the ViewPager
        // and provide a smooth flow for infinite scroll

        binding.viewpager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    when (binding.viewpager.currentItem) {
                        listSize - 1 -> binding.viewpager.setCurrentItem(1, false)
                        0 -> binding.viewpager.setCurrentItem(listSize - 2, false)
                    }
                }
            }
        })
    }




}