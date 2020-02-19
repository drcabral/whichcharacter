package com.promagnoli.whichcharacter.di.module

import com.promagnoli.whichcharacter.view.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainModule(private val mainActivity: MainActivity) {

    @Provides
    fun providesMainActivity(): MainActivity = mainActivity

}