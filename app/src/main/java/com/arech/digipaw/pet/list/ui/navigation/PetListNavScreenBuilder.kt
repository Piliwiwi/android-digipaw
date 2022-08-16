package com.arech.digipaw.pet.list.ui.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.arech.digipaw.pet.list.presentation.AddViewModel
import com.arech.digipaw.pet.list.presentation.ListViewModel
import com.arech.digipaw.pet.list.presentation.add.AddUiState
import com.arech.digipaw.pet.list.presentation.add.AddUiState.DefaultUiState
import com.arech.digipaw.pet.list.presentation.list.ListUiState
import com.arech.digipaw.pet.list.ui.add.AddIntentHandler
import com.arech.digipaw.pet.list.ui.add.AddScreen
import com.arech.digipaw.pet.list.ui.detail.DetailScreen
import com.arech.digipaw.pet.list.ui.list.ListIntentHandler
import com.arech.digipaw.pet.list.ui.list.ListScreen

/**
 * Created by Pili Arancibia on 15-08-22.
 */

fun NavGraphBuilder.listNav(
    viewModel: ListViewModel,
    intentHandler: ListIntentHandler,
    navActions: PetListNavActions
) =
    composable(
        route = PetListRoutes.List.path
    ) {
        val listUiState: ListUiState by viewModel.uiStates()
            .collectAsState(initial = ListUiState.DefaultUiState)
        remember {
            viewModel.processUserIntents(intentHandler.userIntents())
        }

        ListScreen(
            state = listUiState,
            intentHandler = intentHandler,
            navActions = navActions
        )
    }

fun NavGraphBuilder.addNav(
    viewModel: AddViewModel,
    intentHandler: AddIntentHandler,
    navActions: PetListNavActions
) =
    composable(
        route = PetListRoutes.Add.path
    ) {
        val addUiState: AddUiState by viewModel.uiStates().collectAsState(initial = DefaultUiState)
        remember {
            viewModel.processUserIntents(intentHandler.userIntents())
        }

        val addUiEffect = viewModel.uiEffect()

        AddScreen(
            state = addUiState,
            effect = addUiEffect,
            intentHandler = intentHandler,
            navActions = navActions
        )
    }

fun NavGraphBuilder.detailNav(
    navActions: PetListNavActions
) {
    val route = PetListRoutes.Detail()
    return composable(
        route = route.path + "/{${route.argument}}",
        arguments = listOf(
            navArgument(route.argument) { type = NavType.StringType }
        )
    ) {
        val petId = it.arguments?.getString(route.argument).orEmpty()
        DetailScreen(petId)
    }
}