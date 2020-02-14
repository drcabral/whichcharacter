package com.promagnoli.whichcharacter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.promagnoli.whichcharacter.R
import com.promagnoli.whichcharacter.di.component.DaggerCharactersComponent
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

        DaggerCharactersComponent.create().inject(this)

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
        val randomCharacter = presenter.getRandomCharacter()

        txt_character_name.text = randomCharacter.name
        txt_description.text = randomCharacter.description

        Picasso.get().load(randomCharacter.imageUrl).into(img_character)
    }
}
