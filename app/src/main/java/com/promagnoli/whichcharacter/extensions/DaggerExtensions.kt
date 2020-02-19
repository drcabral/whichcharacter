package com.promagnoli.whichcharacter.extensions

import android.app.Activity
import com.promagnoli.whichcharacter.WhichCharacterApp
import com.promagnoli.whichcharacter.di.component.DaggerMainComponent
import com.promagnoli.whichcharacter.di.component.DaggerRandomCharacterComponent
import com.promagnoli.whichcharacter.di.component.MainComponent
import com.promagnoli.whichcharacter.di.component.RandomCharacterComponent
import com.promagnoli.whichcharacter.di.module.MainModule
import com.promagnoli.whichcharacter.di.module.RandomCharacterModule
import com.promagnoli.whichcharacter.view.MainActivity
import com.promagnoli.whichcharacter.view.RandomCharacterActivity

val Activity.applicationComponent get() = (application as WhichCharacterApp).getApplicationComponent()

val MainActivity.mainActivityComponent: MainComponent
    get() = DaggerMainComponent
        .builder()
        .applicationComponent(applicationComponent)
        .mainModule(MainModule(this))
        .build()

val RandomCharacterActivity.randomCharacterComponent: RandomCharacterComponent
    get() = DaggerRandomCharacterComponent
        .builder()
        .applicationComponent(applicationComponent)
        .randomCharacterModule(RandomCharacterModule(this))
        .build()