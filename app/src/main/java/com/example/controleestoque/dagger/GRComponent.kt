package com.example.controleestoque.dagger

import com.example.controleestoque.services.repository.GameRepository
import com.example.controleestoque.ui.view.MainActivity
import dagger.Component

@Component(modules = [GRModule::class])
interface GRComponent {

    fun inject(gameRepository: GameRepository)

}