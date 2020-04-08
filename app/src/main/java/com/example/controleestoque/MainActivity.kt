package com.example.controleestoque

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.controleestoque.dagger.DaggerMAComponent
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var requisition: Requisition

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMAComponent.builder().build().inject(this)

        recycle.layoutManager = LinearLayoutManager(this)

        requisition.getGames().enqueue(object : Callback<ArrayList<Game>> {
            override fun onFailure(call: Call<ArrayList<Game>>, t: Throwable) {
            }

            override fun onResponse(call: Call<ArrayList<Game>>, response: Response<ArrayList<Game>>) {
                recycle.adapter = GamesAdapter(response.body())
            }
        })
    }
}
