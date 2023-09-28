package com.abulnes.trucker_app.navigation.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

fun NavController.navigateToSignIn(){
    this.navigate(SignIn.route)
}

fun NavController.navigateToSignUp(){
    this.navigate(SignUp.route)
}

fun NavController.navigateToForgotPassword(){
    this.navigate(ForgotPassword.route)
}

fun NavController.navigateToCreatePassword(){
    this.navigate(CreatePassword.route)
}