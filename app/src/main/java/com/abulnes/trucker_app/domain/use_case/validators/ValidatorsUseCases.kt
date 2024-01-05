package com.abulnes.trucker_app.domain.use_case.validators

data class ValidatorsUseCases(
    val validateEmail: ValidateEmail,
    val validatePassword: ValidatePassword,
    val validateSignUp: ValidateSignUp
)
