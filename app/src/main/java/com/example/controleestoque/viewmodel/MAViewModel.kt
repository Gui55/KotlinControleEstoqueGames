package com.example.controleestoque.viewmodel

import androidx.lifecycle.ViewModel
import com.example.controleestoque.services.repository.GameRepository

class MAViewModel : ViewModel() {

    //Ao atribuir um valor para a variavel, o Kotlin ja sabe automaticamente o tipo dela
    var gamesGotten = GameRepository.instance.getTheGames()

}