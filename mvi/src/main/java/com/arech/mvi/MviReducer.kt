package com.arech.mvi

import com.arech.mvi.events.MviResult
import com.arech.mvi.events.MviUiState

interface MviReducer<TUiState : MviUiState, TResult : MviResult> {
    infix fun TUiState.reduceWith(result: TResult): TUiState
}