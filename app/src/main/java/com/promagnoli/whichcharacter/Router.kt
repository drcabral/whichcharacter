package com.promagnoli.whichcharacter

import android.app.Activity
import android.content.Intent
import com.promagnoli.whichcharacter.view.RandomCharacterActivity

fun goToRandomCharacterActivity(view: Activity) {
    val intent = Intent(view, RandomCharacterActivity::class.java)
    view.startActivity(intent)
}