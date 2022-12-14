package com.arech.digipaw.pet.list.ui.add

import com.arech.digipaw.pet.list.presentation.add.AddUIntent
import com.arech.digipaw.pet.list.presentation.add.AddUIntent.AddNewPetUIntent
import com.arech.digipaw.pet.list.presentation.model.PetCard
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

@FlowPreview
@ExperimentalCoroutinesApi
class AddIntentHandler @Inject constructor() {
    private val userIntents = MutableSharedFlow<AddUIntent>()
    var coroutineScope: CoroutineScope? = null

    fun userIntents(): Flow<AddUIntent> = userIntents.asSharedFlow()

    fun addNewPetUIntent(newPet: PetCard) {
        emit(AddNewPetUIntent(newPet))
    }

    private fun emit(intent: AddUIntent) {
        coroutineScope?.launch {
            userIntents.emit(intent)
        }
    }
}