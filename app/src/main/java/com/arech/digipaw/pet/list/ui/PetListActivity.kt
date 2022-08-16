package com.arech.digipaw.pet.list.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import com.arech.digipaw.pet.list.presentation.AddViewModel
import com.arech.digipaw.pet.list.presentation.ListViewModel
import com.arech.digipaw.pet.list.presentation.add.AddUIntent
import com.arech.digipaw.pet.list.ui.navigation.PetListNavGraph
import com.arech.uicomponents.theme.DigipawComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * Created by Pili Arancibia on 14-08-22.
 */

@AndroidEntryPoint
@FlowPreview
@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
class PetListActivity : ComponentActivity() {
    private val addViewModel: AddViewModel by viewModels()
    private val listViewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigipawComposeTheme {
                PetListNavGraph(
                    listViewModel = listViewModel,
                    addViewModel = addViewModel
                )
            }
        }
    }

//    override fun onStart() {
//        super.onStart()
//        subscribeStatesProcessIntents()
//    }
//
//    private fun subscribeStatesProcessIntents() {
//        addViewModel.processUserIntents(userIntents.asSharedFlow())
//    }

    private fun setupObservers() {
//        with(viewModel) {
//            uiStates().onEach { AddScreen(viewModel, userIntents, DefaultUiState) }.launchIn(lifecycleScope)
//            uiEffect().onEach { renderUiStates(it) }.launchIn(lifecycleScope)
//        }
    }

    companion object {
        fun makeIntent(context: Context) = Intent(context, PetListActivity::class.java)
    }
}