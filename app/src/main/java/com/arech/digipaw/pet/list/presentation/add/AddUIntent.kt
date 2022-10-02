package com.arech.digipaw.pet.list.presentation.add

import com.arech.digipaw.pet.list.presentation.model.PetCard
import com.arech.mvi.events.MviUserIntent

sealed class AddUIntent : MviUserIntent {
    data class AddNewPetUIntent(val pet: PetCard) : AddUIntent()
    data class AddNewPetRetryUIntent(val pet: PetCard) : AddUIntent()
}