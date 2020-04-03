package com.example.controleestoque

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycle.layoutManager = LinearLayoutManager(this)

        Retrofit.Builder().baseUrl("https://5e878423781e48001676bce6.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Requisition::class.java)
            .getGames()
            .enqueue(object : Callback<ArrayList<Game>> {
                override fun onFailure(call: Call<ArrayList<Game>>, t: Throwable) {
                }

                override fun onResponse(call: Call<ArrayList<Game>>, response: Response<ArrayList<Game>>) {
                    recycle.adapter = GamesAdapter(response.body())
                }
            })
    }
}
