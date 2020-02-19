package com.promagnoli.whichcharacter.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.promagnoli.whichcharacter.R
import com.promagnoli.whichcharacter.entity.CharacterEntity
import com.promagnoli.whichcharacter.extensions.randomCharacterComponent
import com.promagnoli.whichcharacter.presenter.RandomCharacterPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_random_character.*
import javax.inject.Inject

class RandomCharacterActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: RandomCharacterPresenter

    private var swipeRefreshLayout: SwipeRefreshLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_character)

        configureSwipeRefresh()
        randomCharacterComponent.inject(this)
        presenter.attributeRandomCharacter()
    }

    private fun configureSwipeRefresh() {
        swipeRefreshLayout = swipe_refresh

        swipeRefreshLayout?.setOnRefreshListener {
            presenter.attributeRandomCharacter()
        }
    }

    fun setCharacter(character: CharacterEntity) {
        txt_character_name.text = character.name
        txt_description.text = character.description

        Picasso.get().load(character.imageUrl).into(img_character)
        swipeRefreshLayout?.isRefreshing = false
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.disposeCalls()
    }
}
