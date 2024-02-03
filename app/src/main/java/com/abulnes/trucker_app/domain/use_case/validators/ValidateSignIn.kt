package com.abulnes.trucker_app.domain.use_case.validators

import javax.inject.Inject

class ValidateSignIn @Inject constructor(
    private val validateEmail: ValidateEmail,
    private val validatePassword: ValidatePassword
) {

    operator fun invoke(email: String, password: String): Boolean {
        return validateEmail(email) && validatePassword(password)
    }
}