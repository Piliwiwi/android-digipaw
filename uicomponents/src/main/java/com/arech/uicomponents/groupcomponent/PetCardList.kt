package com.arech.uicomponents.groupcomponent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.arech.uicomponents.R
import com.arech.uicomponents.component.AttrsPetCard
import com.arech.uicomponents.component.PetCard

/**
 * Created by Pili Arancibia on 14-08-22.
 */

@Composable
fun PetCardList(attrs: AttrsPetCardList) {
    LazyColumn {
        items(attrs.pets) { pet ->
            PetCard(
                modifier = Modifier.padding(top = dimensionResource(id = R.dimen.ui_margin_12)),
                attrs = pet
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PetCardListPreview() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PetCardList(
                attrs = AttrsPetCardList(
                    pets = listOf(
                        AttrsPetCard(
                            name = "Peluo",
                            animal = "Gato",
                            breed = "Pelo",
                            isMale = true,
                            age = "4 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
                            name = "Siri",
                            animal = "Gata",
                            breed = "Apple",
                            isMale = false,
                            age = "2 años",
                            description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                        ),
                        AttrsPetCard(
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

data class AttrsPetCardList(
    val pets: List<AttrsPetCard>
)