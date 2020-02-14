package com.promagnoli.whichcharacter.di.component

import com.promagnoli.whichcharacter.di.module.MainModule
import com.promagnoli.whichcharacter.view.MainActivity
import com.promagnoli.whichcharacter.view.RandomCharacterActivity
import dagger.Component

@Component(modules = [MainModule::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(randomCharacterActivity: RandomCharacterActivity)
}