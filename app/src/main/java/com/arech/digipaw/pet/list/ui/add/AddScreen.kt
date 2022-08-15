package com.arech.digipaw.pet.list.ui.add

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import com.arech.digipaw.pet.list.presentation.AddViewModel
import com.arech.digipaw.pet.list.presentation.add.AddUIntent
import com.arech.digipaw.pet.list.presentation.add.AddUIntent.AddNewPetUIntent
import com.arech.digipaw.pet.list.presentation.add.AddUiEffect
import com.arech.digipaw.pet.list.presentation.add.AddUiEffect.PetAddedUiEffect
import com.arech.digipaw.pet.list.presentation.add.AddUiState
import com.arech.digipaw.pet.list.presentation.add.AddUiState.DefaultUiState
import com.arech.digipaw.pet.list.presentation.add.AddUiState.ErrorUiState
import com.arech.digipaw.pet.list.presentation.model.Age
import com.arech.digipaw.pet.list.presentation.model.Gender
import com.arech.digipaw.pet.list.presentation.model.PetCard
import com.arech.uicomponents.component.AttrsAvatarSelector
import com.arech.uicomponents.component.AttrsInputPaw
import com.arech.uicomponents.component.AvatarSelector
import com.arech.uicomponents.component.InputPaw
import com.arech.uicomponents.navigation.DigipawTopAppBar
import com.arech.utils.testing.RandomFactory.generateString
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

/**
 * Created by Pili Arancibia on 14-08-22.
 */

@ExperimentalCoroutinesApi
@FlowPreview
@Composable
fun AddScreen(
    viewModel: AddViewModel,
    userIntents: MutableSharedFlow<AddUIntent>,
    state: AddUiState,
    effect: AddUiEffect? = null
) {

    when(state) {
        DefaultUiState -> {}
        ErrorUiState -> {}
    }

    when (effect) {
        PetAddedUiEffect -> {
            Snackbar(

                action = {
                    Button(onClick = {}) {
                        Text("MyAction")
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) { Text(text = "This is a snackbar!") }
        }
        else -> {}
    }

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
                onClick = {
                    viewModel.viewModelScope.launch {
                        userIntents.emit(
                            AddNewPetUIntent(
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
                        )
                    }
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