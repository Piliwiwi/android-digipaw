package com.arech.digipaw.pet.list.presentation

import androidx.lifecycle.ViewModel
import com.arech.digipaw.pet.list.presentation.list.ListAction.LoadPetCardListAction
import com.arech.digipaw.pet.list.presentation.list.ListProcessor
import com.arech.digipaw.pet.list.presentation.list.ListReducer
import com.arech.digipaw.pet.list.presentation.list.ListUIntent
import com.arech.digipaw.pet.list.presentation.list.ListUIntent.SeeMyPetCardsInitialUIntent
import com.arech.digipaw.pet.list.presentation.list.ListUIntent.SeeMyPetCardsRetryUIntent
import com.arech.digipaw.pet.list.presentation.list.ListUiState
import com.arech.digipaw.pet.list.presentation.list.ListUiState.DefaultUiState
import com.arech.mvi.MviPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.scan

@FlowPreview
@ExperimentalCoroutinesApi
@HiltViewModel
class ListViewModel @Inject constructor(
    private val processor: ListProcessor,
    private val reducer: ListReducer
) : ViewModel(),
    MviPresentation<ListUIntent, ListUiState> {
    private val defaultUiState: ListUiState = DefaultUiState
    private val uiState: MutableStateFlow<ListUiState> = MutableStateFlow(defaultUiState)

    override fun processAndObserveUserIntents(userIntents: Flow<ListUIntent>): Flow<ListUiState> =
        userIntents
            .buffer()
            .flatMapMerge { userIntent ->
                processor.actionProcessor(userIntent.toAction())
            }
            .scan(defaultUiState) { currentUiState, result ->
                with(reducer) { currentUiState reduce result }
            }

    private fun ListUIntent.toAction() =
        when (this) {
            SeeMyPetCardsInitialUIntent, SeeMyPetCardsRetryUIntent -> LoadPetCardListAction
        }

    override fun uiStates() = uiState
}