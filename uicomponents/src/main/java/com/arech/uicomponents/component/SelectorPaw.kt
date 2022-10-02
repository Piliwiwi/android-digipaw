package com.arech.uicomponents.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun SelectorPaw(attrs: AttrsSelectorPaws) {
    SelectorPawContent(attrs)
}


@Composable
fun SelectorPawContent(attrs: AttrsSelectorPaws) {
    Dialog(onDismissRequest = { /*TODO*/ }) {
        Surface(
            Modifier
                .background(Color.White)
                .padding(horizontal = 20.dp, vertical = 20.dp)) {
            Column() {
                val selected = remember {
                    mutableStateOf(-1)
                }
                Text(text = "¿Qué animal es tu mascota?")
                Spacer(modifier = Modifier.height(4.dp))

                LazyColumn() {
                    items(attrs.listToSelect.size, itemContent = { item ->
                        Row(
                            modifier = Modifier.height(30.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = selected.value == item,
                                onClick = {
                                    selected.value = item
                                    attrs.onSelect(attrs.listToSelect[item])
                                    attrs.onDismissRequest.invoke()
                                })
                            Text(
                                text = attrs.listToSelect[item]
                            )
                        }
                    })
                }
            }
        }
    }
}

data class AttrsSelectorPaws(
    val listToSelect: List<String>,
    val onSelect: (String) -> Unit,
    val onDismissRequest: () -> Unit
)