package com.example.controleestoque.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.controleestoque.R
import com.example.controleestoque.dagger.DaggerMAComponent
import com.example.controleestoque.dagger.MAModule
import com.example.controleestoque.services.model.Game
import com.example.controleestoque.ui.adapter.GamesAdapter
import com.example.controleestoque.viewmodel.MAViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MAViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMAComponent.builder().mAModule(MAModule(this)).build().inject(this)

        recycle.layoutManager = LinearLayoutManager(this)

        //Lembrando: Em uma LiveData, um dos modos de se obter o valor de uma variavel e observando ela
        //Mas ao observa-la, deve-se fazer alguma coisa com ela, neste caso jogando no adapter da RecyclerView
        viewModel.gamesGotten.observe(this, object : Observer<ArrayList<Game>> {
            override fun onChanged(t: ArrayList<Game>?) {
                recycle.adapter = GamesAdapter(t)
            }

        })
    }
}
