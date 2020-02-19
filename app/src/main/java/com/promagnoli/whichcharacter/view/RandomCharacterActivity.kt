package com.promagnoli.whichcharacter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.promagnoli.whichcharacter.R
import com.promagnoli.whichcharacter.WhichCharacterApp
import com.promagnoli.whichcharacter.di.component.DaggerRandomCharacterComponent
import com.promagnoli.whichcharacter.di.module.RandomCharacterModule
import com.promagnoli.whichcharacter.entity.CharacterEntity
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

        val applicationComponent = (application as WhichCharacterApp).getApplicationComponent()

        DaggerRandomCharacterComponent
            .builder()
            .applicationComponent(applicationComponent)
            .randomCharacterModule(RandomCharacterModule(this))
            .build()
            .inject(this)

        swipeRefreshLayout = swipe_refresh

        configureSwipeRefresh()
        showRandomCharacter()
    }

    private fun configureSwipeRefresh() {
        swipeRefreshLayout?.setOnRefreshListener {
            showRandomCharacter()
            swipeRefreshLayout?.isRefreshing = false
        }
    }

    private fun showRandomCharacter() {
        presenter.getRandomCharacter()
    }

    fun setCharacter(character: CharacterEntity) {
        txt_character_name.text = character.name
        txt_description.text = character.description

        Picasso.get().load(character.imageUrl).into(img_character)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.disposeCalls()
    }
}
