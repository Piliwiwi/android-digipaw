package com.arech.uicomponents.component

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
fun PetCard(modifier: Modifier = Modifier, attrs: AttrsPetCard) {
    val genderResource = getGenderResource(attrs.isMale)
    Card(
        modifier = modifier.clickable { attrs.onclick },
        elevation = dimensionResource(id = R.dimen.ui_elevation_10),
        border = BorderStroke(
            dimensionResource(id = R.dimen.ui_size_2),
            colorResource(id = genderResource.borderColor)
        )
    ) {
        PetCardContent(attrs, genderResource)
    }
}

@Composable
private fun PetCardContent(attrs: AttrsPetCard, genderResource: GenderResource) {
    Row(
        modifier = Modifier
            .background(color = colorResource(id = genderResource.backgroundColor))
            .padding(dimensionResource(id = R.dimen.ui_margin_16))
    ) {
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
                text = attrs.name
            )
        }
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = attrs.animal,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Row() {
                    Text(
                        modifier = Modifier.padding(end = dimensionResource(id = R.dimen.ui_margin_6)),
                        text = attrs.breed,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.ui_dark_gray),
                        fontSize = 16.sp
                    )
                    Image(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        painter = painterResource(id = genderResource.icon),
                        contentDescription = null
                    )
                }
            }
            Text(
                modifier = Modifier.padding(top = dimensionResource(id = R.dimen.ui_margin_12)),
                text = attrs.age,
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
                text = attrs.description
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
            PetCard(
                attrs = AttrsPetCard(
                    id = "1",
                    name = "Misifus",
                    animal = "Gato",
                    breed = "Romano",
                    isMale = true,
                    age = "4 años",
                    description = "“Este gato duerme 16 horas al día le gusta jugar con pantuflas y comer bolsas de basura nuevas, peligroso”"
                )
            )
        }
    }
}

private fun getGenderResource(isMale: Boolean): GenderResource =
    GenderResource(
        icon = if (isMale) R.drawable.ic_male_symbol_14dp else R.drawable.ic_female_symbol_17dp,
        backgroundColor = if (isMale) R.color.ui_male else R.color.ui_female,
        borderColor = if (isMale) R.color.ui_male_stroke else R.color.ui_female_stroke
    )

data class AttrsPetCard(
    val id: String,
    val name: String,
    val animal: String,
    val breed: String,
    val isMale: Boolean,
    val age: String,
    val description: String,
    var onclick: (String) -> Unit = { _ -> }
)

private data class GenderResource(
    @DrawableRes val icon: Int,
    @ColorRes val backgroundColor: Int,
    @ColorRes val borderColor: Int
)