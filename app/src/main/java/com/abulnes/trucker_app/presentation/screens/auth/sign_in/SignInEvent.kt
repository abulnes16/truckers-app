package com.abulnes.trucker_app.presentation.screens.auth.sign_in

import com.abulnes.trucker_app.presentation.screens.auth.sign_up.SignUpEvent

sealed class SignInEvent {
    data class OnEmailChange(val email: String) : SignInEvent()
    data class OnPasswordChange(val password: String): SignInEvent()
    data class OnRememberMeChange(val rememberMe: Boolean): SignInEvent()
    data class OnShowPassword(val showPassword: Boolean): SignInEvent()
    object OnSignIn: SignInEvent()

}
