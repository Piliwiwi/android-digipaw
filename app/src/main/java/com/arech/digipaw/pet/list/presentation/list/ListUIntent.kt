package com.arech.digipaw.pet.list.presentation.list

import com.arech.mvi.events.MviUserIntent

/**
 * Created by Pili Arancibia on 15-08-22.
 */

sealed class ListUIntent : MviUserIntent {
    object SeeMyPetCardsInitialUIntent : ListUIntent()
    object SeeMyPetCardsRetryUIntent : ListUIntent()
}