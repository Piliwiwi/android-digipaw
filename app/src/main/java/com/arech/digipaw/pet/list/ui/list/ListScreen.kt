package com.arech.digipaw.pet.list.ui.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arech.digipaw.pet.list.presentation.list.ListUiState
import com.arech.digipaw.pet.list.presentation.list.ListUiState.DefaultUiState
import com.arech.digipaw.pet.list.presentation.list.ListUiState.ErrorUiState
import com.arech.digipaw.pet.list.presentation.list.ListUiState.LoadingUiState
import com.arech.digipaw.pet.list.presentation.list.ListUiState.ShowPetCardListUiState
import com.arech.digipaw.pet.list.presentation.model.Gender
import com.arech.digipaw.pet.list.presentation.model.PetCard
import com.arech.digipaw.pet.list.ui.navigation.PetListNavActions
import com.arech.uicomponents.component.AttrsPetCard
import com.arech.uicomponents.groupcomponent.AttrsPetCardList
import com.arech.uicomponents.groupcomponent.PetCardList
import com.arech.uicomponents.navigation.DigipawTopAppBar
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
@Composable
fun ListScreen(
    state: ListUiState,
    intentHandler: ListIntentHandler,
    navActions: PetListNavActions
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            DigipawTopAppBar(text = "Mascotas")
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navActions.navToAdd()
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        isFloatingActionButtonDocked = true
    ) {
        when (state) {
            DefaultUiState -> {}
            ErrorUiState -> ErrorView()
            LoadingUiState -> LoadingView()
            is ShowPetCardListUiState -> PetList(data = state.pets,navActions = navActions)
        }
    }
}

@Composable
fun ListScreenContent() {

}

@Composable
fun LoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Loading..",
            fontSize = 18.sp
        )
    }
}

@Composable
fun ErrorView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "ERROR",
            fontSize = 18.sp
        )
    }
}

@Composable
fun PetList(data: List<PetCard>, navActions: PetListNavActions) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PetCardList(
            modifier = Modifier.padding(horizontal = 36.dp),
            attrs = AttrsPetCardList(
                onclick = { navActions.navToDetail(it) },
                pets = data.map {
                    AttrsPetCard(
                        id = it.id,
                        name = it.name,
                        age = it.age.description,
                        breed = it.breed,
                        description = it.description,
                        isMale = it.gender.type == Gender.Male.type,
                        animal = it.animal,
                        photo = it.photo
                    )
                }
            )
        )
    }
}

@Preview
@Composable
fun ListScreenPreview() {
    //ListScreen()
}