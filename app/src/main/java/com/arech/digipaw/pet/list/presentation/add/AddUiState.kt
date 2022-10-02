package com.arech.digipaw.pet.list.presentation.add

import com.arech.mvi.events.MviUiState

sealed class AddUiState : MviUiState {
    object DefaultUiState : AddUiState()
    object ErrorUiState : AddUiState()
}