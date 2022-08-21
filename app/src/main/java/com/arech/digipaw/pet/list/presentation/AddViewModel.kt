package com.arech.digipaw.pet.list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arech.digipaw.pet.list.presentation.add.AddAction.SaveNewPetAction
import com.arech.digipaw.pet.list.presentation.add.AddProcessor
import com.arech.digipaw.pet.list.presentation.add.AddReducer
import com.arech.digipaw.pet.list.presentation.add.AddResult
import com.arech.digipaw.pet.list.presentation.add.AddResult.SaveNewPetResult.Completed
import com.arech.digipaw.pet.list.presentation.add.AddUIntent
import com.arech.digipaw.pet.list.presentation.add.AddUIntent.AddNewPetRetryUIntent
import com.arech.digipaw.pet.list.presentation.add.AddUIntent.AddNewPetUIntent
import com.arech.digipaw.pet.list.presentation.add.AddUiEffect
import com.arech.digipaw.pet.list.presentation.add.AddUiEffect.PetAddedUiEffect
import com.arech.digipaw.pet.list.presentation.add.AddUiState
import com.arech.digipaw.pet.list.presentation.add.AddUiState.DefaultUiState
import com.arech.mvi.MviPresentation
import com.arech.mvi.MviPresentationEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.scan

/**
 * Created by Pili Arancibia on 15-08-22.
 */

@FlowPreview
@ExperimentalCoroutinesApi
@HiltViewModel
class AddViewModel @Inject constructor(
    private val processor: AddProcessor,
    private val reducer: AddReducer
) : ViewModel(),
    MviPresentation<AddUIntent, AddUiState>,
    MviPresentationEffect<AddUiEffect> {
    private val defaultUiState: AddUiState = DefaultUiState
    private val uiState: MutableStateFlow<AddUiState> = MutableStateFlow(defaultUiState)
    private val uiEffect: MutableSharedFlow<AddUiEffect> = MutableSharedFlow()

    override fun processUserIntents(userIntent: AddUIntent) {
        processor.actionProcessor(userIntent.toAction())
            .handleEffect()
            .scan(defaultUiState) { currentUiState, result ->
                with(reducer) { currentUiState reduce result }
            }
            .onEach { uiState ->
                this.uiState.value = uiState
            }
            .launchIn(viewModelScope)
    }

    private fun AddUIntent.toAction() =
        when (this) {
            is AddNewPetUIntent -> SaveNewPetAction(pet)
            is AddNewPetRetryUIntent -> SaveNewPetAction(pet)
        }

    private fun Flow<AddResult>.handleEffect(): Flow<AddResult> =
        onEach { change ->
            val event = when (change) {
                is Completed -> PetAddedUiEffect
                else -> return@onEach
            }
            uiEffect.emit(event)
        }

    override fun uiStates() = uiState
    override fun uiEffect() = uiEffect.asSharedFlow()
}