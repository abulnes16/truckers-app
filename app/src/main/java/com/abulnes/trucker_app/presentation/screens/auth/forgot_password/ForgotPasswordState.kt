package com.abulnes.trucker_app.presentation.screens.auth.forgot_password

data class ForgotPasswordState(
    val email: String = "",
    val emailError: Boolean = false,
    val loading: Boolean = false,
    val isFormValid: Boolean = true,
)
