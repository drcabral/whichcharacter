package com.promagnoli.whichcharacter.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.promagnoli.whichcharacter.R
import com.promagnoli.whichcharacter.di.component.DaggerCharactersComponent
import com.promagnoli.whichcharacter.goToRandomCharacterActivity
import com.promagnoli.whichcharacter.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: MainPresenter

    private lateinit var recyclerAdapter: RecyclerAdapter
    private lateinit var layoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerCharactersComponent.create().inject(this)

        configureCharactersList()
        configureRandomCharacterButton()
    }

    private fun configureCharactersList() {
        layoutManager = LinearLayoutManager(this)
        list_characters.layoutManager = layoutManager

        recyclerAdapter = RecyclerAdapter(presenter.retrieveCharactersNames())
        list_characters.adapter = recyclerAdapter

        val itemDecoration: ItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        list_characters.addItemDecoration(itemDecoration)
    }

    private fun configureRandomCharacterButton() {
        btn_random.setOnClickListener {
            goToRandomCharacterActivity(this)
        }
    }
}
