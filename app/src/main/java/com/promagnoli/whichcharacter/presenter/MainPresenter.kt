package com.promagnoli.whichcharacter.presenter

import com.promagnoli.whichcharacter.interactor.CharactersInteractor
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val interactor: CharactersInteractor
) {

    fun retrieveCharactersNames(): List<String> {
        return interactor.retrieveCharacters().map { characterEntity -> characterEntity.name }
    }
}