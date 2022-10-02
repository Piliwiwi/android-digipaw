package com.arech.digipaw.pet.list.presentation.list

import com.arech.mvi.events.MviUserIntent

sealed class ListUIntent : MviUserIntent {
    object SeeMyPetCardsInitialUIntent : ListUIntent()
    object SeeMyPetCardsRetryUIntent : ListUIntent()
}