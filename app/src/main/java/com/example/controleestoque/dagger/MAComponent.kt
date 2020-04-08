package com.example.controleestoque.dagger

import com.example.controleestoque.ui.view.MainActivity
import dagger.Component

@Component(modules = [MAModule::class])
interface MAComponent {

    fun inject(mainActivity: MainActivity)

}