package com.abulnes.trucker_app.navigation.auth

import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.abulnes.trucker_app.navigation.home.navigateToHome
import com.abulnes.trucker_app.presentation.screens.auth.create_password.CreatePasswordScreen
import com.abulnes.trucker_app.presentation.screens.auth.forgot_password.ForgotPasswordScreen
import com.abulnes.trucker_app.presentation.screens.auth.sign_in.SignInScreen
import com.abulnes.trucker_app.presentation.screens.auth.sign_up.SignUpScreen
import com.abulnes.trucker_app.presentation.screens.auth.welcome.WelcomeScreen
import com.abulnes.trucker_app.presentation.screens.auth.welcome.WelcomeViewModel
import com.abulnes.trucker_app.presentation.utils.authentication.GoogleAuthUiClient

const val AUTH_ROUTE = "auth"

fun NavGraphBuilder.authGraph(
    navController: NavController,
    snackBarHostState: SnackbarHostState
) {
    navigation(startDestination = Welcome.route, route = AUTH_ROUTE) {

        composable(Welcome.route) {
            WelcomeScreen(
                onClickSignIn = { navController.navigateToSignIn() },
                onClickSignUp = { navController.navigateToSignUp() },
            )
        }
        composable(SignIn.route) {
            SignInScreen(
                onSignIn = { navController.navigateToHome() },
                onClickSignUp = { navController.navigateToSignUp() },
                onClickForgotPassword = { navController.navigateToForgotPassword() },
                snackBarHostState = snackBarHostState
            )
        }
        composable(SignUp.route) {
            SignUpScreen(
                onSignUp = { navController.navigateToHome() },
                onClickSignIn = { navController.navigateToSignIn() },
                snackBarHostState = snackBarHostState
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

