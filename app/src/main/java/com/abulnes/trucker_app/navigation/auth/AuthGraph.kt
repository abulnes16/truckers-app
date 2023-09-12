package com.abulnes.trucker_app.navigation.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.abulnes.trucker_app.ui.screens.auth.ForgotPasswordScreen
import com.abulnes.trucker_app.ui.screens.auth.SignInScreen
import com.abulnes.trucker_app.ui.screens.auth.SignUpScreen
import com.abulnes.trucker_app.ui.screens.auth.WelcomeScreen

const val AUTH_ROUTE = "auth"

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation(startDestination = Welcome.route, route = AUTH_ROUTE) {
        composable(Welcome.route) {
            WelcomeScreen()
        }
        composable(SignIn.route) {
            SignInScreen()
        }
        composable(SignUp.route) {
            SignUpScreen()
        }
        composable(ForgotPassword.route) {
            ForgotPasswordScreen()
        }
    }
}