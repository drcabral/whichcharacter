package com.promagnoli.whichcharacter.interactor

import com.promagnoli.whichcharacter.BuildConfig
import com.promagnoli.whichcharacter.entity.MarvelResponse
import com.promagnoli.whichcharacter.service.MarvelService
import com.promagnoli.whichcharacter.extensions.toMD5
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.time.Instant
import javax.inject.Inject

class CharactersInteractor @Inject constructor(private val marvelService: MarvelService) {

    private val avengersEvent = 271
    private val responseLimit = 100

    fun retrieveCharacters(): Observable<MarvelResponse>? {
        return makeMarvelCall().map { it }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    private fun makeMarvelCall(): Observable<MarvelResponse> {
        val timeStamp = Instant.now().toString()
        val marvelPublicKey = BuildConfig.MARVEL_PUBLIC_KEY
        val marvelPrivateKey = BuildConfig.MARVEL_PRIVATE_KEY

        val hash = (timeStamp + marvelPrivateKey + marvelPublicKey).toMD5()

        return marvelService.listCharacters(
                timeStamp, marvelPublicKey, hash, avengersEvent, responseLimit
        )
    }
}