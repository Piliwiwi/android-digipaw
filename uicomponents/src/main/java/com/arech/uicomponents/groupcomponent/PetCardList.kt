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

@Composable
fun PetCardList(modifier: Modifier = Modifier, attrs: AttrsPetCardList) {
    LazyColumn(modifier) {
        items(attrs.pets) { pet ->
            PetCard(
                modifier = Modifier.padding(top = dimensionResource(id = R.dimen.ui_margin_12)),
                attrs = pet.apply { pet.onclick = attrs.onclick }
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

data class AttrsPetCardList(
    val pets: List<AttrsPetCard>,
    val onclick: (String) -> Unit = { _ -> }
)