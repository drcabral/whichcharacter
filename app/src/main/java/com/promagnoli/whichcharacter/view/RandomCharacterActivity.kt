package com.promagnoli.whichcharacter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.promagnoli.whichcharacter.R
import kotlinx.android.synthetic.main.activity_random_character.*

class RandomCharacterActivity : AppCompatActivity() {

    private var swipeRefreshLayout: SwipeRefreshLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_character)

        swipeRefreshLayout = swipe_refresh

        configureSwipeRefresh()
    }

    private fun configureSwipeRefresh() {
        swipeRefreshLayout?.setOnRefreshListener {
            swipeRefreshLayout?.isRefreshing = false
        }
    }
}
