package com.abulnes.trucker_app.navigation.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.abulnes.trucker_app.navigation.home.navigateToHome
import com.abulnes.trucker_app.ui.screens.auth.CreatePasswordScreen
import com.abulnes.trucker_app.ui.screens.auth.ForgotPasswordScreen
import com.abulnes.trucker_app.ui.screens.auth.SignInScreen
import com.abulnes.trucker_app.ui.screens.auth.SignUpScreen
import com.abulnes.trucker_app.ui.screens.auth.WelcomeScreen

const val AUTH_ROUTE = "auth"

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation(startDestination = Welcome.route, route = AUTH_ROUTE) {

        composable(Welcome.route) {
            WelcomeScreen(
                onClickSignUp = { navController.navigateToSignUp() },
                onClickSignIn = { navController.navigateToSignIn() }
            )
        }
        composable(SignIn.route) {
            SignInScreen(
                onSignIn = { navController.navigateToHome() },
                onClickSignUp = { navController.navigateToSignUp() },
                onClickForgotPassword = { navController.navigateToForgotPassword() }
            )
        }
        composable(SignUp.route) {
            SignUpScreen(
                onSignUp = { navController.navigateToHome() },
                onClickSignIn = { navController.navigateToSignIn() }
            )
        }
        composable(ForgotPassword.route) {
            ForgotPasswordScreen(
                onGoBack = { navController.popBackStack() },
                onCreatePassword = { navController.navigateToCreatePassword() }
            )
        }

        composable(CreatePassword.route) {
            CreatePasswordScreen(
                onGoBack = { navController.popBackStack() },
                onResetPassword = { navController.navigateToHome() }
            )
        }
    }
}

