package com.raiserdev.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.raiserdev.ui.ChatScreen
import mx.kcosmo.conversations.ui.ConversationListScreen
import mx.kcosmo.create_chat.CreateConversationsScreen
import mx.kcosmo.framework.navigation.NavRoutes

@Suppress("ktlint:standard:function-naming")
@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoutes.ConversationsList) {
        addConversationList(navController)
        addNewConversation(navController)
        addChat(navController)
    }
}

private fun NavGraphBuilder.addConversationList(navController: NavHostController) {
    composable(NavRoutes.ConversationsList) {
        ConversationListScreen(onNewConversationClick = { navController.navigate(NavRoutes.NewConversation) }) { chatId ->
            navController.navigate(NavRoutes.Chat.replace("{chatId}", chatId))
        }
    }
}

private fun NavGraphBuilder.addNewConversation(navController: NavHostController) {
    composable(NavRoutes.NewConversation) {
        CreateConversationsScreen()
        // CreateConversationScreen(onCreateConversation = { navController.navigate(NavRoutes.Chat)})
    }
}

private fun NavGraphBuilder.addChat(navController: NavHostController) {
    composable(
        route = NavRoutes.Chat,
        arguments =
            listOf(
                navArgument(NavRoutes.ChatArgs.ChatId) {
                    type = NavType.StringType
                },
            ),
    ) { navBackStackEntry ->
        val chatId =
            navBackStackEntry.arguments?.getString(
                NavRoutes.ChatArgs.ChatId,
            )
        ChatScreen(
            chatId = chatId,
            onBack = {
                navController.popBackStack()
            },
        )
    }
}

/*
@Composable
fun WhatsPacktNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "start_screen"
    ) {

        composable(
            "start_screen"
        ) {
            MainScreen(navController)
        }

        composable(
            route = NavRoutes.Chat,
            arguments = listOf(
                navArgument(NavRoutes.ChatArgs.ChatId) {
                    type = NavType.StringType
                }
            ),
            deepLinks = listOf(navDeepLink { uriPattern = "whatspackt://chat/{id}" })
        ) { navBackStackEntry ->
            val chatId = navBackStackEntry.arguments?.getString(
                NavRoutes.ChatArgs.ChatId
            )
            ChatScreen(chatId = chatId, onBack = {
                navController.popBackStack()
            })
        }
    }
}*/
