package com.abulnes.trucker_app.presentation.screens.auth.forgot_password

sealed class ForgotPasswordEvent {
    data class  onEmailChange(val email: String): ForgotPasswordEvent()
    object OnRecoverPassword: ForgotPasswordEvent()
}
