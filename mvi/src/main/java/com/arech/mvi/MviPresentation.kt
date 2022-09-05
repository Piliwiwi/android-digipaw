package com.arech.mvi

import com.arech.mvi.events.MviUiState
import com.arech.mvi.events.MviUserIntent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MviPresentation<TUserIntent : MviUserIntent, TUiState : MviUiState> {
    fun processAndObserveUserIntents(userIntents: Flow<TUserIntent>): Flow<TUiState>
    fun uiStates(): StateFlow<TUiState>
}