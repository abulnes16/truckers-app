package com.abulnes.trucker_app.presentation.screens.auth.sign_up

sealed class SignUpEvent{
    data class OnNameChange(val name: String): SignUpEvent()
    data class OnEmailChange(val email: String): SignUpEvent()
    data class OnPasswordChange(val password: String): SignUpEvent()
    object OnRememberUser: SignUpEvent()
    object OnSignUp: SignUpEvent()

    object OnGoogleSignUp: SignUpEvent()
}
