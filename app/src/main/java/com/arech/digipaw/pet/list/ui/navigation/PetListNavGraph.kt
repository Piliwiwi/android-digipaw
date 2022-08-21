package com.arech.digipaw.pet.list.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.arech.digipaw.pet.list.presentation.AddViewModel
import com.arech.digipaw.pet.list.presentation.ListViewModel
import com.arech.digipaw.pet.list.ui.add.AddIntentHandler
import com.arech.digipaw.pet.list.ui.list.ListIntentHandler
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

/**
 * Created by Pili Arancibia on 15-08-22.
 */

@FlowPreview
@ExperimentalCoroutinesApi
@Composable
fun PetListNavGraph(
    startDestination: String = PetListRoutes.List.path
) {
    val navController = rememberNavController()
    val navActions = remember(navController) { PetListNavActions(navController) }

    val listViewModel = hiltViewModel<ListViewModel>()
    val addViewModel = hiltViewModel<AddViewModel>()

    val listIntentHandler = ListIntentHandler().apply {
        this.viewModel = listViewModel
    }
    val addIntentHandler = AddIntentHandler().apply {
        this.viewModel = addViewModel
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        listNav(
            viewModel = listViewModel,
            intentHandler = listIntentHandler,
            navActions = navActions
        )
        addNav(
            viewModel = addViewModel,
            intentHandler = addIntentHandler,
            navActions = navActions
        )
        detailNav(
            navActions = navActions
        )
    }
}