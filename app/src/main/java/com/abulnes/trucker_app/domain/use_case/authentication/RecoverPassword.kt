package com.abulnes.trucker_app.domain.use_case.authentication

import com.abulnes.trucker_app.domain.repository.AuthRepository
import javax.inject.Inject

class RecoverPassword @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String): Result<Boolean>{
        return authRepository.recoverPassword(email)
    }
}