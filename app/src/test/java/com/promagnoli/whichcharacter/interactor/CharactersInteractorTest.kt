package com.promagnoli.whichcharacter.interactor

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.promagnoli.whichcharacter.entity.Data
import com.promagnoli.whichcharacter.entity.MarvelResponse
import com.promagnoli.whichcharacter.entity.Results
import com.promagnoli.whichcharacter.entity.Thumbnail
import com.promagnoli.whichcharacter.service.MarvelService
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharactersInteractorTest {

    private val thumbnail = Thumbnail("path", ".jpg")

    @Test
    fun valuesAreSameAsService() {
        val marvelResponse =
            MarvelResponse(Data(listOf(Results("A Name", "A Description", thumbnail))))

        val marvelService = mock<MarvelService>()

        doReturn(Observable.just(marvelResponse)).`when`(marvelService).listCharacters(
            ArgumentMatchers.anyString(),
            ArgumentMatchers.anyString(),
            ArgumentMatchers.anyString(),
            ArgumentMatchers.anyInt(),
            ArgumentMatchers.anyInt()
        )

        val charactersInteractor = CharactersInteractor(marvelService)

        val testObserver = TestObserver<MarvelResponse>()

        charactersInteractor.retrieveCharacters()?.subscribe(testObserver)

        testObserver.awaitTerminalEvent()

        testObserver.assertValues(marvelResponse)
    }
}