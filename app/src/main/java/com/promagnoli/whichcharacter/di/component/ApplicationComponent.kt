package com.promagnoli.whichcharacter.di.component

import android.content.Context
import com.promagnoli.whichcharacter.di.module.ApplicationModule
import com.promagnoli.whichcharacter.di.module.ServiceModule
import com.promagnoli.whichcharacter.service.MarvelService
import dagger.Component

@Component(modules = [ApplicationModule::class, ServiceModule::class])
interface ApplicationComponent {
    fun getContext(): Context
    fun gerMarvelService(): MarvelService
}