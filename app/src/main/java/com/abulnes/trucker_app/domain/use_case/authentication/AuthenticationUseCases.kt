package com.abulnes.trucker_app.domain.use_case.authentication

data class AuthenticationUseCases(
    val registerUser: RegisterUser,
    val authenticate: Authenticate,
)
