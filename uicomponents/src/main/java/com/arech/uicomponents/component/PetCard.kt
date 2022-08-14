package com.arech.uicomponents.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by Pili Arancibia on 14-08-22.
 */

@Composable
fun PetCard() {
    Card(
        modifier = Modifier,
        elevation = 10.dp,
        border = BorderStroke(1.dp, Color.Black)
    ) {
        PetCardContent()
    }
}

@Composable
fun PetCardContent() {
    Row(modifier = Modifier.padding(15.dp)) {
        Column(Modifier.padding(end = 15.dp)) {
            Text(
                text = "PRIMERO"
            )
        }
        Column() {
            Text(
                text = "SEGUNDO"
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PetCardPreview() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
            PetCard()
        }
    }
}