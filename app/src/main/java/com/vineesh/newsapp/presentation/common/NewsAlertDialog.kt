package com.vineesh.newsapp.presentation.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun NewsAlertDialog(
    title: String,
    message: String,
    okMessage: String,
    cancelMessage: String,
    okClick: () -> Unit,
    cancelClick: () -> Unit,
    openDialog: Boolean
) {

    if (openDialog) {
        AlertDialog(
            onDismissRequest = {
                false
            },
            title = {
                Text(text = title)
            },
            text = {
                Text(message)
            },
            confirmButton = {
                if (okMessage.isNotEmpty()){
                    TextButton(
                        onClick = {
                            okClick.invoke()
                        }
                    ) {
                        Text(okMessage)
                    }
                }
            },
            dismissButton = {
                if (cancelMessage.isNotEmpty()){
                    TextButton(
                        onClick = {
                         cancelClick.invoke()
                        }
                    ) {
                        Text(cancelMessage)
                    }
                }
            }
        )
    }
}