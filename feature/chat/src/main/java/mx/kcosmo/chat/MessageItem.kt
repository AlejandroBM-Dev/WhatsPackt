package mx.kcosmo.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mx.kcosmo.chat.model.Message
import mx.kcosmo.framework.navigation.Avatar

@Composable
fun MessageItem(message: Message) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (message.isMine)
        Arrangement.End else Arrangement.Start
    ) {
        if (message.isMine) {
            Avatar(
                imageUrl = message.senderAvatar,
                size = 40.dp,
                contentDescription = "${message.senderAvatar}´s avatar"
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}