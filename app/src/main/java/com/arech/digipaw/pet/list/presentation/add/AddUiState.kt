package com.arech.digipaw.pet.list.presentation.add

import com.arech.mvi.events.MviUiState

/**
 * Created by Pili Arancibia on 15-08-22.
 */

sealed class AddUiState : MviUiState {
    object DefaultUiState : AddUiState()
    object ErrorUiState : AddUiState()
}