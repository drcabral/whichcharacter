package com.promagnoli.whichcharacter.presenter

import com.promagnoli.whichcharacter.entity.CharacterEntity
import com.promagnoli.whichcharacter.entity.MarvelResponse
import com.promagnoli.whichcharacter.interactor.CharactersInteractor
import com.promagnoli.whichcharacter.view.RandomCharacterActivity
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class RandomCharacterPresenter @Inject constructor(
    private val interactor: CharactersInteractor,
    private val randomCharacterActivity: RandomCharacterActivity
) {
    private var disposable: Disposable? = null

    fun getRandomCharacter() {
        disposable = interactor.retrieveCharacters()?.subscribe {
            val characters = transformResponse(it)
            randomCharacterActivity.setCharacter(characters.random())
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