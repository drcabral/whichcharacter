package com.promagnoli.whichcharacter.presenter

import com.promagnoli.whichcharacter.entity.CharacterEntity
import com.promagnoli.whichcharacter.interactor.CharactersInteractor
import javax.inject.Inject

class RandomCharacterPresenter @Inject constructor(
    private val interactor: CharactersInteractor
) {
    fun getRandomCharacter(): CharacterEntity {
        return interactor.retrieveCharacters().random()
    }
}