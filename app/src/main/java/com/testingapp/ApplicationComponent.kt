package com.testingapp

import android.content.Context
import androidx.lifecycle.ViewModel
import com.testingapp.di.NetworkModule
import com.testingapp.di.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(mainActivity: MainActivity2)

    fun getMap() : Map<Class<*>, ViewModel>

    @Component.Factory
    fun interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}