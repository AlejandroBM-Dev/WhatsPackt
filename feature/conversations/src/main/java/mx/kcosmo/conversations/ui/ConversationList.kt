package mx.kcosmo.conversations.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import mx.kcosmo.conversations.ui.model.Conversation

@Suppress("ktlint:standard:function-naming")
@Composable
fun ConversationList(
    conversations: List<Conversation>,
    onConversationClick: () -> Unit,
) {
    LazyColumn {
        items(conversations) { conversation ->
            ConversationItem(
                conversation = conversation,
            )
        }
    }
}
