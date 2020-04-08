package com.example.controleestoque.services.webservices

import com.example.controleestoque.services.model.Game
import retrofit2.Call
import retrofit2.http.GET

interface Requisition {

    @GET("games")
    fun getGames(): Call<ArrayList<Game>>

}