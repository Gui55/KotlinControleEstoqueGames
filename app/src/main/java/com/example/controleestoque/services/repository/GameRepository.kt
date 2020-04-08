package com.example.controleestoque.services.repository

import androidx.lifecycle.MutableLiveData
import com.example.controleestoque.dagger.DaggerGRComponent
import com.example.controleestoque.services.model.Game
import com.example.controleestoque.services.webservices.Requisition
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GameRepository {

    @Inject
    lateinit var requisition: Requisition

    //Construtor
    init{
        DaggerGRComponent.builder().build().inject(this)
    }

    companion object{
        val instance = GameRepository()
    }

    fun getTheGames() : MutableLiveData<ArrayList<Game>>{

        var theGames = MutableLiveData<ArrayList<Game>>()

        requisition.getGames().enqueue(object : Callback<ArrayList<Game>> {
            override fun onFailure(call: Call<ArrayList<Game>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<ArrayList<Game>>,
                response: Response<ArrayList<Game>>
            ) {
                theGames.value = response.body()
            }
        })

        return theGames

    }

}