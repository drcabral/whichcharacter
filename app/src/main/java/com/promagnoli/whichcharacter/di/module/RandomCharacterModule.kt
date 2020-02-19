package com.promagnoli.whichcharacter.di.module

import com.promagnoli.whichcharacter.view.RandomCharacterActivity
import dagger.Module
import dagger.Provides

@Module
class RandomCharacterModule(private val randomCharacterActivity: RandomCharacterActivity) {

    @Provides
    fun providesRandomCharacterActivity(): RandomCharacterActivity = randomCharacterActivity
}
