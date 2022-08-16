package com.arech.digipaw.pet.list.ui.navigation

/**
 * Created by Pili Arancibia on 15-08-22.
 */

sealed class PetListRoutes(val path: String) {
    object List : PetListRoutes(path = "list")
    object Add : PetListRoutes(path = "add")
    data class Detail(val argument: String = "petId"): PetListRoutes(path = "detail")
}