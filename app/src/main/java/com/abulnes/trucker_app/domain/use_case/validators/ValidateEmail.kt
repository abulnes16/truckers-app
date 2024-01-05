package com.abulnes.trucker_app.domain.use_case.validators

private const val EMAIL_REGEX = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"

class ValidateEmail {
    operator fun invoke(email: String): Boolean{
            val emailRegex = Regex(EMAIL_REGEX)
            return email.matches(emailRegex)
    }
}