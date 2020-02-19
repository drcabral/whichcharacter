package com.promagnoli.whichcharacter.presenter

import com.promagnoli.whichcharacter.entity.CharacterEntity
import com.promagnoli.whichcharacter.entity.MarvelResponse
import com.promagnoli.whichcharacter.interactor.CharactersInteractor
import com.promagnoli.whichcharacter.view.MainActivity
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val interactor: CharactersInteractor,
    private val mainActivity: MainActivity
) {
    private var disposable: Disposable? = null

    fun configureCharactersList() {
        disposable = interactor.retrieveCharacters()?.subscribe {
            val characters = transformResponse(it)
            mainActivity.setCharactersList(characters = characters.map { character -> character.name })
        }
    }

    private fun transformResponse(response: MarvelResponse): MutableList<CharacterEntity> {
        val characters = mutableListOf<CharacterEntity>()
        response.data.results.forEach { result ->
            val imageUrl = result.thumbnail.path + "." + result.thumbnail.extension
            val characterEntity = CharacterEntity(result.name, result.description, imageUrl)
            characters.add(characterEntity)
        }

        return characters
    }

    fun disposeCalls() {
        if (disposable != null && disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }
}