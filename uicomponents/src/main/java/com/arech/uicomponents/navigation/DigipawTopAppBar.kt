package com.arech.uicomponents.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

/**
 * Created by Pili Arancibia on 14-08-22.
 */

@Composable
fun DigipawTopAppBar(text: String) {
    TopAppBar {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}