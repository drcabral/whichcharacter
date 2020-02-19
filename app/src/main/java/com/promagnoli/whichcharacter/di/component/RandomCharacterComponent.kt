package com.promagnoli.whichcharacter.di.component

import com.promagnoli.whichcharacter.di.module.RandomCharacterModule
import com.promagnoli.whichcharacter.view.RandomCharacterActivity
import dagger.Component

@Component(modules = [RandomCharacterModule::class], dependencies = [ApplicationComponent::class])
interface RandomCharacterComponent {
    fun inject(randomCharacterActivity: RandomCharacterActivity)
}