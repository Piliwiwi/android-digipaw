package com.arech.digipaw.pet.list.presentation.add

import com.arech.mvi.events.MviEffect

sealed class AddUiEffect : MviEffect {
    object PetAddedUiEffect : AddUiEffect()
}
