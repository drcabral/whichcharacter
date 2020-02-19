package com.promagnoli.whichcharacter.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.promagnoli.whichcharacter.R
import kotlinx.android.synthetic.main.activity_characters_list_item.view.*

class RecyclerAdapter(private val charactersNames: List<String>) :
    RecyclerView.Adapter<RecyclerAdapter.CharactersHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_characters_list_item, parent, false)

        return CharactersHolder(view)
    }

    override fun getItemCount() = charactersNames.size

    override fun onBindViewHolder(holder: CharactersHolder, position: Int) {
        holder.itemView.item_name.text = charactersNames[position]
    }

    class CharactersHolder(view: View) : RecyclerView.ViewHolder(view)
}
