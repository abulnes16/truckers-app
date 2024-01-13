package com.abulnes.trucker_app.presentation.screens.auth.sign_up

data class SignUpState(
    val name: String,
    val email: String,
    val password: String,
    val loading: Boolean,
    val nameError: Boolean = false,
    val emailError: Boolean = false,
    val passwordError: Boolean = false,
    val showPassword: Boolean = false,
)
