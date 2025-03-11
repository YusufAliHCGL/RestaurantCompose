package com.example.restaurantcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restaurantcompose.presentation.screens.ForgotPasswordScreen
import com.example.restaurantcompose.presentation.screens.HomeScreen
import com.example.restaurantcompose.presentation.screens.LoginScreen
import com.example.restaurantcompose.presentation.screens.ResetPasswordScreen
import com.example.restaurantcompose.presentation.util.Screen
import com.example.restaurantcompose.presentation.screens.SignupConfirmScreen
import com.example.restaurantcompose.presentation.screens.SignupScreen
import com.example.restaurantcompose.presentation.screens.StartScreen

import com.example.restaurantcompose.ui.theme.RestaurantComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RestaurantComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.StartScreen.route
                    ) {
                        composable(route = Screen.StartScreen.route) {
                            StartScreen(
                                navController = navController
                            )
                        }
                        composable(route = Screen.SignupScreen.route) {
                            SignupScreen(
                                navController = navController
                            )
                        }
                        composable(route = Screen.SignupConfirmScreen.route) {
                            SignupConfirmScreen(
                                navController = navController
                            )
                        }
                        composable(route = Screen.LoginScreen.route) {
                            LoginScreen(
                                navController = navController
                            )
                        }
                        composable(route = Screen.ForgotPasswordScreen.route) {
                            ForgotPasswordScreen(
                                navController = navController
                            )
                        }
                        composable(route = Screen.ResetPasswordScreen.route) {
                            ResetPasswordScreen(
                                navController = navController
                            )
                        }
                        composable(route = Screen.HomeScreen.route) {
                            HomeScreen(
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}
