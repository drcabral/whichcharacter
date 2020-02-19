package com.promagnoli.whichcharacter

import android.app.Application
import com.promagnoli.whichcharacter.di.component.ApplicationComponent
import com.promagnoli.whichcharacter.di.component.DaggerApplicationComponent
import com.promagnoli.whichcharacter.di.module.ApplicationModule

class WhichCharacterApp: Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(applicationContext))
            .build()
    }

    fun getApplicationComponent(): ApplicationComponent {
        return applicationComponent
    }
}