package com.arech.digipaw.pet.list.presentation.add

import com.arech.mvi.events.MviEffect

/**
 * Created by Pili Arancibia on 15-08-22.
 */

sealed class AddUiEffect : MviEffect {
    object DefaultUiEffect : AddUiEffect()
    object PetAddedUiEffect : AddUiEffect()
}
