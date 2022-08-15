package com.arech.digipaw.pet.list.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arech.digipaw.pet.list.ui.list.ListScreen
import com.arech.uicomponents.theme.DigipawComposeTheme

/**
 * Created by Pili Arancibia on 14-08-22.
 */

class PetListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigipawComposeTheme {
                ListScreen()
            }
        }
    }

    companion object {
        fun makeIntent(context: Context) = Intent(context, PetListActivity::class.java)
    }
}