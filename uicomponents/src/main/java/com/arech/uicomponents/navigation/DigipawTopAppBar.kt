package com.arech.uicomponents.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

/**
 * Created by Pili Arancibia on 14-08-22.
 */

@Composable
fun DigipawTopAppBar(text: String, backArrowClick: (() -> Unit)? = null) {
    TopAppBar {
        if (backArrowClick != null) ToolbarBackArrow(backArrowClick)
        ToolbarText(text)
    }
}

@Composable
private fun ToolbarBackArrow(onclick: () -> Unit) {
    Icon(
        imageVector = Icons.Default.ArrowBack,
        contentDescription = null,
        modifier = Modifier.clickable { onclick() }
    )
}

@Composable
private fun ToolbarText(text: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}