package com.raiserdev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.raiserdev.ui.navigation.MainNavigation
import com.raiserdev.ui.theme.WhatsPacktTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsPacktTheme {
                //StartNav...
                val navHostController = rememberNavController()
                MainNavigation(navController = navHostController)

            }
        }
    }
}