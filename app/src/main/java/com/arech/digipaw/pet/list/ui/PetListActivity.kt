package com.arech.digipaw.pet.list.ui

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arech.digipaw.pet.list.ui.add.AddScreen
import com.arech.uicomponents.theme.DigipawComposeTheme

/**
 * Created by Pili Arancibia on 14-08-22.
 */

class PetListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigipawComposeTheme {
                AddScreen()
            }
        }
    }

    companion object {
        fun makeIntent(context: Context) = Intent(context, PetListActivity::class.java)
    }
}