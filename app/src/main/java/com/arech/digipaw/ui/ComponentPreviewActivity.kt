package com.arech.digipaw.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arech.uicomponents.component.PetCard
import com.arech.uicomponents.theme.DigipawComposeTheme

/**
 * Created by Pili Arancibia on 14-08-22.
 */

class ComponentPreviewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigipawComposeTheme {
                PetCard()
            }
        }
    }

    companion object {
        fun makeIntent(context: Context) = Intent(context, ComponentPreviewActivity::class.java)
    }
}