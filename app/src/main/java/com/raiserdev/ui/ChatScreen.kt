package com.raiserdev.ui

import androidx.compose.runtime.Composable

@Suppress("ktlint:standard:function-naming")
@Composable
fun ChatScreen(
    chatId: String?,
    onBack: () -> Unit,
)  {
    object {
        val uri = "whatspackt://chat/{id}"
        val name = "chat?id={id}"
    }
}
