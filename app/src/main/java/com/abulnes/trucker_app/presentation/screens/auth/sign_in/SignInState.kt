package com.abulnes.trucker_app.presentation.screens.auth.sign_in

data class SignInState(
    val email: String = "",
    val password: String = "",
    val emailError: Boolean = false,
    val showPassword: Boolean = false,
    val loading: Boolean = false,
)
