package com.arech.uicomponents.component

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.arech.uicomponents.R

/**
 * Created by Pili Arancibia on 14-08-22.
 */

@Composable
fun PetCard(attrs: AttrsPetCard) {
    Card(
        modifier = Modifier,
        elevation = dimensionResource(id = R.dimen.ui_elevation_10),
        border = BorderStroke(dimensionResource(id = R.dimen.ui_size_1), Color.Black)
    ) {
        PetCardContent(attrs)
    }
}

@Composable
fun PetCardContent(attrs: AttrsPetCard) {
    Row(modifier = Modifier.padding(dimensionResource(id = R.dimen.ui_margin_16))) {
        Column(
            modifier = Modifier
                .padding(end = dimensionResource(id = R.dimen.ui_margin_16))
                .width(dimensionResource(id = R.dimen.ui_size_89))
        ) {
            Image(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.ui_size_89))
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.cat_example),
                contentScale = ContentScale.Fit,
                contentDescription = null
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                text = "Misifus"
            )
        }
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Gato",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Row() {
                    Text(
                        modifier = Modifier.padding(end = dimensionResource(id = R.dimen.ui_margin_6)),
                        text = "Romano",
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.ui_dark_gray),
                        fontSize = 16.sp
                    )
                    Image(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        painter = painterResource(id = R.drawable.ic_male_symbol_14px),
                        contentDescription = null
                    )
                }
            }
            Text(
                modifier = Modifier.padding(top = dimensionResource(id = R.dimen.ui_margin_12)),
                text = "4 años",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.ui_dark_gray),
                fontSize = 12.sp
            )
            Text(
                modifier = Modifier.padding(top = dimensionResource(id = R.dimen.ui_margin_12)),
                fontSize = 10.sp,
                fontStyle = FontStyle.Italic,
                color = colorResource(id = R.color.ui_gray),
                text = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
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
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            PetCard()
        }
    }
}

data class AttrsPetCard(
    val name: String,
    val animal: String,
    val breed: String,
    val isMale: Boolean,
    val age: String,
    val description: String
)

private data class GenderResource(
    @DrawableRes val icon: Int,
    @ColorRes val backgroundColor: Int,
    @ColorRes val borderColor: Int
)