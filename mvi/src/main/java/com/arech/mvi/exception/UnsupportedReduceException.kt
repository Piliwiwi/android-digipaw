package com.arech.mvi.exception

import com.arech.mvi.events.MviResult
import com.arech.mvi.events.MviUiState
import java.lang.RuntimeException

class UnsupportedReduceException(state: MviUiState, result: MviResult) :
    RuntimeException("Cannot reduce state: $state with result: $result")