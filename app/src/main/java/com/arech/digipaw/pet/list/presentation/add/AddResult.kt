package com.arech.digipaw.pet.list.presentation.add

import com.arech.mvi.events.MviResult

/**
 * Created by Pili Arancibia on 15-08-22.
 */

sealed class AddResult : MviResult {
    sealed class SaveNewPetResult : AddResult() {
        object Default : SaveNewPetResult()
        object Error : SaveNewPetResult()
        object Completed : SaveNewPetResult()
    }
}