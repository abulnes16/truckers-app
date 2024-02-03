package com.abulnes.trucker_app.presentation.screens.auth.sign_up



sealed class SignUpEvent{
    data class OnNameChange(val name: String): SignUpEvent()
    data class OnEmailChange(val email: String): SignUpEvent()
    data class OnPasswordChange(val password: String): SignUpEvent()
    data class OnRememberUser(val rememberSession: Boolean): SignUpEvent()

    data class OnShowPassword(val show: Boolean): SignUpEvent()
    object OnSignUp: SignUpEvent()
}
