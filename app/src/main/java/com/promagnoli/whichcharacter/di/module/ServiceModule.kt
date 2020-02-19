package com.promagnoli.whichcharacter.di.module

import com.promagnoli.whichcharacter.service.MarvelService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val MARVEL_URL = "https://gateway.marvel.com:443/v1/public/"

@Module
class ServiceModule {

    @Provides
    fun providesPhrasesService(): MarvelService = Retrofit.Builder()
        .baseUrl(MARVEL_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(MarvelService::class.java)
}