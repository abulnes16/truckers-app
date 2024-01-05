package com.abulnes.trucker_app.domain.use_case.validators

import javax.inject.Inject

class ValidateSignUp @Inject constructor(
    private val validateEmail: ValidateEmail,
    private val validatePassword: ValidatePassword
) {

    operator  fun invoke(name: String,email: String, password: String): Boolean{
        return name.isNotBlank() && validateEmail(email) && validatePassword(password)
    }
}