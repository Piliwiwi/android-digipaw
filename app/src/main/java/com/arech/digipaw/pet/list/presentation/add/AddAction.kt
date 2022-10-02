package com.arech.digipaw.pet.list.presentation.add

import com.arech.digipaw.pet.list.presentation.model.PetCard
import com.arech.mvi.events.MviAction

sealed class AddAction : MviAction {
    data class SaveNewPetAction(val pet: PetCard) : AddAction()
}