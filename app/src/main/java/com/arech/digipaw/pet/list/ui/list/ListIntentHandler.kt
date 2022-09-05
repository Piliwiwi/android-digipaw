package com.arech.digipaw.pet.list.ui.list

import com.arech.digipaw.pet.list.presentation.ListViewModel
import com.arech.digipaw.pet.list.presentation.add.AddUIntent
import com.arech.digipaw.pet.list.presentation.list.ListUIntent
import com.arech.digipaw.pet.list.presentation.list.ListUIntent.SeeMyPetCardsInitialUIntent
import com.arech.digipaw.pet.list.presentation.list.ListUIntent.SeeMyPetCardsRetryUIntent
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.launch

/**
 * Created by Pili Arancibia on 15-08-22.
 */

@ExperimentalCoroutinesApi
class ListIntentHandler @Inject constructor() {
    private val userIntents = MutableSharedFlow<ListUIntent>()
    var coroutineScope: CoroutineScope? = null

    fun userIntents(): Flow<ListUIntent> = merge(
        flow { emit(SeeMyPetCardsInitialUIntent) },
        userIntents.asSharedFlow()
    )

    fun initialUintent() {
        emit(SeeMyPetCardsInitialUIntent)
    }

    fun retryUIntent() {
        emit(SeeMyPetCardsRetryUIntent)
    }

    private fun emit(intent: ListUIntent) {
        coroutineScope?.launch {
            userIntents.emit(intent)
        }
    }
}