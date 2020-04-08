package com.example.controleestoque.dagger

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.controleestoque.viewmodel.MAViewModel
import dagger.Module
import dagger.Provides

@Module
class MAModule(var viewModelStoreOwner: ViewModelStoreOwner) {

    @Provides
    fun provideVM() : MAViewModel {
        return ViewModelProvider(viewModelStoreOwner)[MAViewModel::class.java]
    }

}