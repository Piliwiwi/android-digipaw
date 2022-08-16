package com.arech.digipaw.pet.list.ui.navigation

import androidx.navigation.NavHostController

/**
 * Created by Pili Arancibia on 15-08-22.
 */

class PetListNavActions(private val navHostController: NavHostController) {
    fun navToList() {
        navHostController.navigate(PetListRoutes.List.path)
    }

    fun navToAdd() {
        navHostController.navigate(PetListRoutes.Add.path)
    }

    fun popBackStack() {
        navHostController.popBackStack()
    }
}