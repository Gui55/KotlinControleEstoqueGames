package com.example.controleestoque.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.controleestoque.R
import com.example.controleestoque.services.model.Game
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_line.view.*

class GamesAdapter(private val games: ArrayList<Game>?) : RecyclerView.Adapter<GamesAdapter.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_line,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return games!!.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games!![position]

        Picasso.get().load(game.image).into(holder.image)
        holder.title.text = game.id.toString()+". "+game.name
        holder.stock.text = "Stock: "+game.stock.toString()
    }

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image = itemView.gameImage
        val title = itemView.gameTitle
        val stock = itemView.gameStock

    }

}