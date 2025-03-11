package com.example.restaurantcompose.presentation.util

sealed class Screen(val route: String) {
    object StartScreen: Screen(route = "start_screen")
    object SignupScreen: Screen(route = "signup_screen")
    object SignupConfirmScreen: Screen(route = "signup_confirm_screen")
    object LoginScreen: Screen(route = "login_screen")
    object ForgotPasswordScreen: Screen(route = "forgot_password_screen")
    object ResetPasswordScreen: Screen(route = "reset_password_screen")
    object HomeScreen: Screen(route = "home_screen")

}