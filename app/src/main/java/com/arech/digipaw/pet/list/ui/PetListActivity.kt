package com.arech.digipaw.pet.list.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.arech.digipaw.pet.list.presentation.AddViewModel
import com.arech.digipaw.pet.list.presentation.add.AddUIntent
import com.arech.digipaw.pet.list.presentation.add.AddUiState
import com.arech.digipaw.pet.list.presentation.add.AddUiState.DefaultUiState
import com.arech.digipaw.pet.list.ui.add.AddScreen
import com.arech.uicomponents.theme.DigipawComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Created by Pili Arancibia on 14-08-22.
 */

@AndroidEntryPoint
@FlowPreview
@ExperimentalCoroutinesApi
class PetListActivity : ComponentActivity() {
    private val viewModel: AddViewModel by viewModels()
    private val userIntents: MutableSharedFlow<AddUIntent> = MutableSharedFlow()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigipawComposeTheme {
                AddScreen(viewModel, userIntents, DefaultUiState)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        subscribeStatesProcessIntents()
    }

    private fun subscribeStatesProcessIntents() {
        viewModel.processUserIntents(userIntents.asSharedFlow())
    }

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