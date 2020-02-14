package com.promagnoli.whichcharacter.view

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.promagnoli.whichcharacter.R
import com.promagnoli.whichcharacter.inflate

class RecyclerAdapter(private val charactersNames: List<String>) :
    RecyclerView.Adapter<RecyclerAdapter.CharactersHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersHolder {
        val inflatedView = parent.inflate(R.layout.activity_characters_list_item, false)
        return CharactersHolder(inflatedView)
    }

    override fun getItemCount() = charactersNames.size

    override fun onBindViewHolder(holder: CharactersHolder, position: Int) {
        val item = charactersNames[position]
        holder.bindName(item)
    }

    class CharactersHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        private var name: String? = null

        override fun onClick(view: View?) {
            val context = itemView.context
            val randomCharacterIntent = Intent(context, MainActivity::class.java)
            context.startActivity(randomCharacterIntent)
        }

        fun bindName(name: String) {
            this.name = name
        }
    }
}
