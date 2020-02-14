package com.promagnoli.whichcharacter.interactor

import com.promagnoli.whichcharacter.BuildConfig
import com.promagnoli.whichcharacter.entity.CharacterEntity
import com.promagnoli.whichcharacter.entity.MarvelResponse
import com.promagnoli.whichcharacter.service.MarvelService
import com.promagnoli.whichcharacter.toMD5
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.Instant
import javax.inject.Inject

class CharactersInteractor @Inject constructor(private val marvelService: MarvelService) {

    private val avengersEvent = 271
    private val responseLimit = 100
    private val characters = mutableListOf<CharacterEntity>()

    fun retrieveCharacters(): List<CharacterEntity> {

        makeMarvelCall().enqueue(object : Callback<MarvelResponse> {

            override fun onResponse(
                call: Call<MarvelResponse>,
                response: Response<MarvelResponse>
            ) {
                createCharactersList(response)
            }

            override fun onFailure(call: Call<MarvelResponse>, t: Throwable) {}
        })

        return characters
    }

    fun makeMarvelCall(): Call<MarvelResponse> {
        val timeStamp = Instant.now().toString()
        val marvelPublicKey = BuildConfig.MARVEL_PUBLIC_KEY
        val marvelPrivateKey = BuildConfig.MARVEL_PRIVATE_KEY

        val hash = (timeStamp + marvelPrivateKey + marvelPublicKey).toMD5()

        return marvelService.listCharacters(
            timeStamp, marvelPublicKey, hash, avengersEvent, responseLimit
        )
    }

    private fun createCharactersList(
        response: Response<MarvelResponse>
    ) {
        response.body()?.data?.results?.forEach { result ->
            val imageUrl = result.thumbnail.path + "." + result.thumbnail.path
            val characterEntity = CharacterEntity(result.name, result.description, imageUrl)
            characters.add(characterEntity)
        }
    }
}