package com.arech.digipaw.pet.list.ui.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arech.digipaw.pet.list.presentation.list.ListUiState
import com.arech.digipaw.pet.list.ui.navigation.PetListNavActions
import com.arech.uicomponents.component.AttrsPetCard
import com.arech.uicomponents.groupcomponent.AttrsPetCardList
import com.arech.uicomponents.groupcomponent.PetCardList
import com.arech.uicomponents.navigation.DigipawTopAppBar
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

/**
 * Created by Pili Arancibia on 14-08-22.
 */

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
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PetCardList(
                modifier = Modifier.padding(horizontal = 36.dp),
                attrs = AttrsPetCardList(
                    onclick = { navActions.navToDetail(it) },
                    pets = listOf(
                        AttrsPetCard(
                            id = "1",
                            name = "Peluo",
                            animal = "Gato",
                            breed = "Pelo",
                            isMale = true,
                            age = "4 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "2",
                            name = "Siri",
                            animal = "Gata",
                            breed = "Apple",
                            isMale = false,
                            age = "2 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "3",
                            name = "Bicho",
                            animal = "Gato",
                            breed = "Insecto",
                            isMale = true,
                            age = "4 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "4",
                            name = "Peluo",
                            animal = "Gato",
                            breed = "Pelo",
                            isMale = true,
                            age = "4 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "5",
                            name = "Siri",
                            animal = "Gata",
                            breed = "Apple",
                            isMale = false,
                            age = "2 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "6",
                            name = "Bicho",
                            animal = "Gato",
                            breed = "Insecto",
                            isMale = true,
                            age = "4 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "7",
                            name = "Peluo",
                            animal = "Gato",
                            breed = "Pelo",
                            isMale = true,
                            age = "4 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "8",
                            name = "Siri",
                            animal = "Gata",
                            breed = "Apple",
                            isMale = false,
                            age = "2 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "9",
                            name = "Bicho",
                            animal = "Gato",
                            breed = "Insecto",
                            isMale = true,
                            age = "4 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "10",
                            name = "Peluo",
                            animal = "Gato",
                            breed = "Pelo",
                            isMale = true,
                            age = "4 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "11",
                            name = "Siri",
                            animal = "Gata",
                            breed = "Apple",
                            isMale = false,
                            age = "2 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "12",
                            name = "Bicho",
                            animal = "Gato",
                            breed = "Insecto",
                            isMale = true,
                            age = "4 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "13",
                            name = "Peluo",
                            animal = "Gato",
                            breed = "Pelo",
                            isMale = true,
                            age = "4 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "14",
                            name = "Siri",
                            animal = "Gata",
                            breed = "Apple",
                            isMale = false,
                            age = "2 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "15",
                            name = "Bicho",
                            animal = "Gato",
                            breed = "Insecto",
                            isMale = true,
                            age = "4 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        )
                    )
                )
            )
        }
    }
}

@Preview
@Composable
fun ListScreenPreview() {
    //ListScreen()
}