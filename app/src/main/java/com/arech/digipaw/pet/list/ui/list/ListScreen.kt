package com.arech.digipaw.pet.list.ui.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arech.uicomponents.component.AttrsPetCard
import com.arech.uicomponents.groupcomponent.AttrsPetCardList
import com.arech.uicomponents.groupcomponent.PetCardList

/**
 * Created by Pili Arancibia on 14-08-22.
 */

@Composable
fun ListScreen() {
    Scaffold(
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PetCardList(
                modifier = Modifier.padding(horizontal = 36.dp),
                attrs = AttrsPetCardList(
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
                            id = "1",
                            name = "Siri",
                            animal = "Gata",
                            breed = "Apple",
                            isMale = false,
                            age = "2 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "1",
                            name = "Bicho",
                            animal = "Gato",
                            breed = "Insecto",
                            isMale = true,
                            age = "4 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
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
                            id = "1",
                            name = "Siri",
                            animal = "Gata",
                            breed = "Apple",
                            isMale = false,
                            age = "2 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "1",
                            name = "Bicho",
                            animal = "Gato",
                            breed = "Insecto",
                            isMale = true,
                            age = "4 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
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
                            id = "1",
                            name = "Siri",
                            animal = "Gata",
                            breed = "Apple",
                            isMale = false,
                            age = "2 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "1",
                            name = "Bicho",
                            animal = "Gato",
                            breed = "Insecto",
                            isMale = true,
                            age = "4 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
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
                            id = "1",
                            name = "Siri",
                            animal = "Gata",
                            breed = "Apple",
                            isMale = false,
                            age = "2 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "1",
                            name = "Bicho",
                            animal = "Gato",
                            breed = "Insecto",
                            isMale = true,
                            age = "4 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
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
                            id = "1",
                            name = "Siri",
                            animal = "Gata",
                            breed = "Apple",
                            isMale = false,
                            age = "2 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            id = "1",
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
    ListScreen()
}