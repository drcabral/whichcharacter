package com.promagnoli.whichcharacter.di.module

import com.promagnoli.whichcharacter.service.MarvelService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class CharactersModule {

    private val marvelUrl = "https://gateway.marvel.com:443/v1/public/"

    @Provides
    fun providesMarvelService(): MarvelService {

        val retrofit = Retrofit.Builder()
            .baseUrl(marvelUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(MarvelService::class.java)
    }
}