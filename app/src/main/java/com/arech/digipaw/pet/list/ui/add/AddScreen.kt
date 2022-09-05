package com.arech.digipaw.pet.list.ui.add

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.arech.uicomponents.component.AvatarSelector
import com.arech.uicomponents.component.InputPaw
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
            DefaultUiState -> {}
            ErrorUiState -> {}
        }

        LaunchedEffect(effect) {
            effect.collect {
                when (it) {
                    PetAddedUiEffect -> {
                        scaffoldState.snackbarHostState.showSnackbar(
                            message = "hello world",
                            actionLabel = "Retry"
                        )
                    }
                    else -> {}
                }
            }
        }

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
                onClick = {
                    intentHandler.addNewPetUIntent(
                        PetCard(
                            id = generateString(),
                            breed = "Raza",
                            description = "Descripcion",
                            animal = "Animal",
                            age = Age(value = 4, "4 años"),
                            gender = Gender.Female,
                            name = generateString(),
                            photo = ""
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
}