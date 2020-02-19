package com.promagnoli.whichcharacter.di.component

import com.promagnoli.whichcharacter.di.module.MainModule
import com.promagnoli.whichcharacter.view.MainActivity
import dagger.Component

@Component(modules = [MainModule::class], dependencies = [ApplicationComponent::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}