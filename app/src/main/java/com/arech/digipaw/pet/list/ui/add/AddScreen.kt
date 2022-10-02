package com.arech.digipaw.pet.list.ui.add

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arech.digipaw.pet.list.presentation.add.AddUiEffect
import com.arech.digipaw.pet.list.presentation.add.AddUiEffect.PetAddedUiEffect
import com.arech.digipaw.pet.list.presentation.add.AddUiState
import com.arech.digipaw.pet.list.presentation.add.AddUiState.DefaultUiState
import com.arech.digipaw.pet.list.presentation.add.AddUiState.ErrorUiState
import com.arech.digipaw.pet.list.presentation.model.Age
import com.arech.digipaw.pet.list.presentation.model.Gender
import com.arech.digipaw.pet.list.presentation.model.PetCard
import com.arech.digipaw.pet.list.ui.navigation.PetListNavActions
import com.arech.uicomponents.component.AttrsAvatarSelector
import com.arech.uicomponents.component.AttrsInputPaw
import com.arech.uicomponents.component.AttrsSelectorPaws
import com.arech.uicomponents.component.AvatarSelector
import com.arech.uicomponents.component.InputPaw
import com.arech.uicomponents.component.SelectorPaw
import com.arech.uicomponents.navigation.DigipawTopAppBar
import com.arech.utils.testing.RandomFactory.generateString
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.SharedFlow

@ExperimentalCoroutinesApi
@FlowPreview
@Composable
fun AddScreen(
    state: AddUiState,
    effect: SharedFlow<AddUiEffect>,
    intentHandler: AddIntentHandler,
    navActions: PetListNavActions,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            DigipawTopAppBar(
                text = "Agrega una Mascota",
                backArrowClick = { navActions.popBackStack() }
            )
        }
    ) {
        when (state) {
            DefaultUiState -> AddContent(intentHandler)
            ErrorUiState -> {}
        }

        LaunchedEffect(effect) {
            effect.collect {
                when (it) {
                    PetAddedUiEffect -> {
                        navActions.popBackStack()
                    }
                    else -> {}
                }
            }
        }
    }
}

@Composable
fun AddContent(intentHandler: AddIntentHandler) {
    var photo: Uri? by remember { mutableStateOf(null) }
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var animal by remember { mutableStateOf("") }
    var animalDialogState by remember { mutableStateOf(false) }
    var gender by remember { mutableStateOf(Gender.Unknown) }
    var genderDialogState by remember { mutableStateOf(false) }

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
            attrs = AttrsAvatarSelector(
                onSelectAvatar = {
                    photo = it
                }
            )
        )

        InputPaw(
            modifier = Modifier.padding(top = 18.dp),
            attrs = AttrsInputPaw(
                placeholder = "Nombre",
                singleLine = true,
                onTextChange = {
                    name = it
                }
            )
        )

        InputPaw(
            modifier = Modifier.padding(top = 18.dp),
            attrs = AttrsInputPaw(
                placeholder = "Animal",
                singleLine = true,
                value = animal,
                readOnly = true,
                onClick = {
                    animalDialogState = true
                }
            )
        )

        if (animalDialogState) {
            SelectorPaw(attrs = AttrsSelectorPaws(
                listToSelect = listOf("Perro", "Gato", "Conejo", "Pollo", "Hamster", "Ratón"),
                onSelect = {
                    animal = it
                },
                onDismissRequest = { animalDialogState = false }
            ))
        }

        InputPaw(
            modifier = Modifier.padding(top = 18.dp),
            attrs = AttrsInputPaw(
                placeholder = "Género",
                singleLine = true,
                value = gender.type,
                readOnly = true,
                onClick = {
                    genderDialogState = true
                }
            )
        )

        if (genderDialogState) {
            SelectorPaw(attrs = AttrsSelectorPaws(
                listToSelect = listOf("Macho", "Hembra"),
                onSelect = {
                    gender = if (it == "Macho") Gender.Male else Gender.Female
                },
                onDismissRequest = { genderDialogState = false }
            ))
        }

        InputPaw(
            modifier = Modifier.padding(top = 18.dp),
            attrs = AttrsInputPaw(
                placeholder = "Descripción",
                onTextChange = {
                    description = it
                }
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
            onClick = {
                intentHandler.addNewPetUIntent(
                    PetCard(
                        id = generateString(),
                        breed = "Raza",
                        description = description,
                        animal = animal,
                        age = Age(value = 4, "4 años"),
                        gender = gender,
                        name = name,
                        photo = "",
                        uriPhoto = photo
                    )
                )
            }
        ) {
            Text(
                text = "¡Añadir!",
                fontSize = 18.sp
            )
        }
    }
}