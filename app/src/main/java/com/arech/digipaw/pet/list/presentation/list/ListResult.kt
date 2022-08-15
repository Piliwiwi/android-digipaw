package com.arech.digipaw.pet.list.presentation.list

import com.arech.digipaw.pet.list.presentation.model.PetCard
import com.arech.mvi.events.MviResult

/**
 * Created by Pili Arancibia on 15-08-22.
 */

sealed class ListResult : MviResult {
    sealed class LoadPetCardListResult : ListResult() {
        object InProgress : LoadPetCardListResult()
        object Error : LoadPetCardListResult()
        data class Success(val pets: List<PetCard>) : LoadPetCardListResult()
    }
}