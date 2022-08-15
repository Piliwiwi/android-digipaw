package com.arech.digipaw.pet.list.ui.navigation

import androidx.navigation.NavHostController

/**
 * Created by Pili Arancibia on 15-08-22.
 */

class PetListNavActions(navHostController: NavHostController) {
    val list: () -> Unit = {
        navHostController.navigate(PetListRoutes.List.path)
    }

    val add: () -> Unit = {
        navHostController.navigate(PetListRoutes.Add.path)
    }
}