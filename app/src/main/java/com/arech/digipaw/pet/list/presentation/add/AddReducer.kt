package com.arech.digipaw.pet.list.presentation.add

import com.arech.digipaw.pet.list.presentation.add.AddResult.SaveNewPetResult.Completed
import com.arech.digipaw.pet.list.presentation.add.AddResult.SaveNewPetResult.Default
import com.arech.digipaw.pet.list.presentation.add.AddResult.SaveNewPetResult.Error
import com.arech.digipaw.pet.list.presentation.add.AddUiState.DefaultUiState
import com.arech.digipaw.pet.list.presentation.add.AddUiState.ErrorUiState
import com.arech.mvi.MviReducer
import com.arech.mvi.exception.UnsupportedReduceException
import javax.inject.Inject

/**
 * Created by Pili Arancibia on 15-08-22.
 */

class AddReducer @Inject constructor() : MviReducer<AddUiState, AddResult> {
    override fun AddUiState.reduceWith(result: AddResult): AddUiState {
        return when (val currentState = this) {
            is DefaultUiState -> currentState reduceWith result
            is ErrorUiState -> currentState reduceWith result
        }
    }

    private infix fun DefaultUiState.reduceWith(result: AddResult): AddUiState {
        return when (result) {
            Error -> ErrorUiState
            Completed -> this
            else -> throw UnsupportedReduceException(this, result)
        }
    }

    private infix fun ErrorUiState.reduceWith(result: AddResult): AddUiState {
        return when (result) {
            Default -> DefaultUiState
            else -> throw UnsupportedReduceException(this, result)
        }
    }
}