package com.arech.digipaw.pet.list.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewModelScope
import com.arech.digipaw.pet.list.presentation.AddViewModel
import com.arech.digipaw.pet.list.presentation.ListViewModel
import com.arech.digipaw.pet.list.ui.add.AddIntentHandler
import com.arech.digipaw.pet.list.ui.list.ListIntentHandler
import com.arech.digipaw.pet.list.ui.navigation.PetListNavGraph
import com.arech.uicomponents.theme.DigipawComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

/**
 * Created by Pili Arancibia on 14-08-22.
 */

@AndroidEntryPoint
@FlowPreview
@ExperimentalCoroutinesApi
class PetListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigipawComposeTheme {
                Surface {
                    PetListNavGraph()
                }
            }
        }
    }

    companion object {
        fun makeIntent(context: Context) = Intent(context, PetListActivity::class.java)
    }
}