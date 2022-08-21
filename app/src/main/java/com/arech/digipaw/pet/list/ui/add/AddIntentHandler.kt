package com.arech.digipaw.pet.list.ui.add

import com.arech.digipaw.pet.list.presentation.AddViewModel
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

/**
 * Created by Pili Arancibia on 15-08-22.
 */

@FlowPreview
@ExperimentalCoroutinesApi
class AddIntentHandler @Inject constructor() {
    var viewModel: AddViewModel? = null

    fun addNewPetUIntent(newPet: PetCard) {
        emit(AddNewPetUIntent(newPet))
    }

    private fun emit(intent: AddUIntent) {
        viewModel?.processUserIntents(intent)
    }
}