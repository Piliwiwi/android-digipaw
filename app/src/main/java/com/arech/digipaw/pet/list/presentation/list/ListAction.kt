package com.arech.digipaw.pet.list.presentation.list

import com.arech.mvi.events.MviAction

/**
 * Created by Pili Arancibia on 15-08-22.
 */

sealed class ListAction : MviAction {
    object LoadPetCardListAction : ListAction()
}
