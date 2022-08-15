package com.arech.digipaw.pet.list.ui.add

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arech.uicomponents.component.AttrsAvatarSelector
import com.arech.uicomponents.component.AttrsInputPaw
import com.arech.uicomponents.component.AvatarSelector
import com.arech.uicomponents.component.InputPaw
import com.arech.uicomponents.navigation.DigipawTopAppBar

/**
 * Created by Pili Arancibia on 14-08-22.
 */

@Composable
fun AddScreen() {


    Scaffold(
        topBar = {
            DigipawTopAppBar(text = "Agrega una Mascota")
        }
    ) {
        Column(horizontalAlignment = CenterHorizontally) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                text = "¡Sube su mejor foto!"
            )
            AvatarSelector(
                modifier = Modifier.wrapContentWidth(align = CenterHorizontally),
                attrs = AttrsAvatarSelector()
            )

            InputPaw(
                modifier = Modifier.padding(top = 18.dp),
                attrs = AttrsInputPaw(
                    placeholder = "Nombre",
                    singleLine = true
                )
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 12.dp),
            contentAlignment = BottomCenter
        ) {
            Button(
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "¡Añadir!",
                    fontSize = 18.sp
                )
            }
        }
    }
}


@Preview
@Composable
fun AddScreenPreview() {
    AddScreen()
}