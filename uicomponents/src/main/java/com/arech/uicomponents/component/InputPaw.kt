package com.arech.uicomponents.component

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged

@Composable
fun InputPaw(modifier: Modifier = Modifier, attrs: AttrsInputPaw) {
    var text by rememberSaveable {
        mutableStateOf(attrs.defaultValue)
    }
    InputPawContent(modifier, text, attrs) { value -> text = value }
}

@Composable
private fun InputPawContent(
    modifier: Modifier,
    text: String,
    attrs: AttrsInputPaw,
    onChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier.onFocusChanged { if (it.isFocused) attrs.onClick?.invoke() },
        label = {
            Text(text = attrs.placeholder)
        },
        readOnly = attrs.readOnly,
        value = attrs.value ?: text,
        singleLine = attrs.singleLine,
        onValueChange = {
            onChange(it)
            attrs.onTextChange(it)
        }
    )
}

data class AttrsInputPaw(
    val placeholder: String,
    val defaultValue: String = "",
    val value: String? = null,
    val singleLine: Boolean = false,
    val readOnly: Boolean = false,
    val onTextChange: (String) -> Unit = { _ -> },
    val onClick: (() -> Unit)? = null
)