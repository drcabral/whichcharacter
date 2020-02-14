package com.promagnoli.whichcharacter.di.component

import com.promagnoli.whichcharacter.di.module.CharactersModule
import com.promagnoli.whichcharacter.view.MainActivity
import com.promagnoli.whichcharacter.view.RandomCharacterActivity
import dagger.Component

@Component(modules = [CharactersModule::class])
interface CharactersComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(randomCharacterActivity: RandomCharacterActivity)
}