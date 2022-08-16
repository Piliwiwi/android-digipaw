package com.arech.digipaw.pet.list.ui.list

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavAction
import com.arech.digipaw.pet.list.presentation.list.ListUIntent
import com.arech.digipaw.pet.list.presentation.list.ListUIntent.SeeMyPetCardsInitialUIntent
import com.arech.digipaw.pet.list.presentation.list.ListUIntent.SeeMyPetCardsRetryUIntent
import com.arech.digipaw.pet.list.ui.navigation.PetListNavActions
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

    fun retryUIntent() {
        emit(SeeMyPetCardsRetryUIntent)
    }

    private fun emit(intent: ListUIntent) {
        coroutineScope?.launch {
            userIntents.emit(intent)
        }
    }
}