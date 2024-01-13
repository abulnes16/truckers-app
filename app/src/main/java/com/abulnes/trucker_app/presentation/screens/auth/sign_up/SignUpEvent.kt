package com.abulnes.trucker_app.presentation.screens.auth.sign_up

import com.abulnes.trucker_app.utils.UiText

sealed class SignUpEvent{
    data class OnNameChange(val name: String): SignUpEvent()
    data class OnEmailChange(val email: String): SignUpEvent()
    data class OnPasswordChange(val password: String): SignUpEvent()
    data class OnRememberUser(val rememberSession: Boolean): SignUpEvent()

    data class OnShowPassword(val show: Boolean): SignUpEvent()
    object OnSignUp: SignUpEvent()

    object OnGoogleSignUp: SignUpEvent()
}
