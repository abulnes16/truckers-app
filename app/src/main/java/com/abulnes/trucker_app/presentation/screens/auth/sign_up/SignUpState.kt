package com.abulnes.trucker_app.presentation.screens.auth.sign_up

data class SignUpState(
    val name: String,
    val email: String,
    val password: String,
    val rememberUser: Boolean
)
