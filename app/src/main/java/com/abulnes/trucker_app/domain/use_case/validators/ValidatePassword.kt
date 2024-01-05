package com.abulnes.trucker_app.domain.use_case.validators


private const val PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$"
class ValidatePassword {

    operator fun invoke(password: String): Boolean {
        val passwordRegex = Regex(PASSWORD_REGEX)
        return password.matches(passwordRegex)
    }
}