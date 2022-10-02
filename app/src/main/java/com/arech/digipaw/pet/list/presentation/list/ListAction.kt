package com.arech.digipaw.pet.list.presentation.list

import com.arech.mvi.events.MviAction

sealed class ListAction : MviAction {
    object LoadPetCardListAction : ListAction()
}
