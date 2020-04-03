package com.example.controleestoque

import retrofit2.Call
import retrofit2.http.GET

interface Requisition {

    @GET("games")
    fun getGames(): Call<ArrayList<Game>>

}