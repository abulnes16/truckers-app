package com.abulnes.trucker_app.domain.use_case.authentication

import com.abulnes.trucker_app.domain.models.User
import com.abulnes.trucker_app.domain.repository.AuthRepository
import javax.inject.Inject

class Authenticate @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Result<User>{
        return authRepository.authenticate(email, password)
    }
}