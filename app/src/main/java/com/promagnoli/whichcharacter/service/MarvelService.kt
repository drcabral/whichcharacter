package com.promagnoli.whichcharacter.service

import com.promagnoli.whichcharacter.entity.MarvelResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    @GET("characters")
    fun listCharacters(
        @Query("ts") ts: String, @Query("apikey") apiKey: String,
        @Query("hash") hash: String, @Query("events") events: Int,
        @Query("limit") limit: Int
    ): Observable<MarvelResponse>
}