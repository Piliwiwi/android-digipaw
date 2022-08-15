package com.arech.digipaw.pet.list.presentation.list

import com.arech.digipaw.pet.list.presentation.list.ListResult.LoadPetCardListResult.Error
import com.arech.digipaw.pet.list.presentation.list.ListResult.LoadPetCardListResult.InProgress
import com.arech.digipaw.pet.list.presentation.list.ListResult.LoadPetCardListResult.Success
import com.arech.digipaw.pet.list.presentation.list.ListUiState.DefaultUiState
import com.arech.digipaw.pet.list.presentation.list.ListUiState.ErrorUiState
import com.arech.digipaw.pet.list.presentation.list.ListUiState.LoadingUiState
import com.arech.digipaw.pet.list.presentation.list.ListUiState.ShowPetCardListUiState
import com.arech.mvi.MviReducer
import com.arech.mvi.exception.UnsupportedReduceException
import javax.inject.Inject

/**
 * Created by Pili Arancibia on 15-08-22.
 */

class ListReducer @Inject constructor() : MviReducer<ListUiState, ListResult> {
    override fun ListUiState.reduce(result: ListResult): ListUiState {
        return when (val currentState = this) {
            is DefaultUiState -> currentState reduceWith result
            is ErrorUiState -> currentState reduceWith result
            is LoadingUiState -> currentState reduceWith result
            is ShowPetCardListUiState -> currentState reduceWith result
        }
    }

    private infix fun DefaultUiState.reduceWith(result: ListResult): ListUiState {
        return when (result) {
            InProgress -> LoadingUiState
            else -> throw UnsupportedReduceException(this, result)
        }
    }

    private infix fun ErrorUiState.reduceWith(result: ListResult): ListUiState {
        return when (result) {
            InProgress -> LoadingUiState
            else -> throw UnsupportedReduceException(this, result)
        }
    }

    private infix fun LoadingUiState.reduceWith(result: ListResult): ListUiState {
        return when (result) {
            Error -> ErrorUiState
            is Success -> ShowPetCardListUiState(result.pets)
            else -> throw UnsupportedReduceException(this, result)
        }
    }

    private infix fun ShowPetCardListUiState.reduceWith(result: ListResult): ListUiState {
        throw UnsupportedReduceException(this, result)
    }
}