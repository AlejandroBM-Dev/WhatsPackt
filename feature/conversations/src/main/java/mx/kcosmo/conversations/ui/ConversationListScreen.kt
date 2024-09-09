package mx.kcosmo.conversations.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import mx.kcosmo.conversations.R
import mx.kcosmo.conversations.ui.model.generateFakeConversations

@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversationListScreen(
    onNewConversationClick: () -> Unit,
    onConversationClick: (chatId: String) -> Unit,
) {
    val tabs = generateTabs()
    val selectedIndex = remember { mutableStateOf(1) }
    val pagerState = rememberPagerState(initialPage = 1) { 3 }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.conversations_list_title))
                },
                actions = {
                    IconButton(
                        onClick = {},
                    ) {
                        Icon(Icons.Rounded.Menu, contentDescription = "Menu")
                    }
                },
            )
        },
        bottomBar = {
            TabRow(selectedTabIndex = 1) {
                tabs.forEachIndexed { index, _ ->
                    Tab(
                        text = {
                            Text(
                                stringResource(tabs[index].title),
                            )
                        },
                        selected = index == 1,
                        onClick = { /* NAV ACTION*/ },
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onNewConversationClick() },
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.f_btn_string_add),
                )
            }
        },
    ) { innerPadding ->
        HorizontalPager(
            modifier = Modifier.padding(innerPadding),
            state = pagerState,
        ) { index ->
            when (index) {
                0 -> {}
                1 -> {
                    ConversationList(
                        conversations = generateFakeConversations(),
                        onConversationClick = { },
                    )
                }
                2 -> {}
            }
        }

        LaunchedEffect(selectedIndex.value) {
            pagerState.animateScrollToPage(selectedIndex.value)
        }
    }
}

data class ConversationsListTabs(
    @StringRes val title: Int,
)

fun generateTabs(): List<ConversationsListTabs> =
    listOf(
        ConversationsListTabs(R.string.conversations_tab_status_title),
        ConversationsListTabs(R.string.conversations_tab_chats_title),
        ConversationsListTabs(R.string.conversations_tab_calls_title),
    )
