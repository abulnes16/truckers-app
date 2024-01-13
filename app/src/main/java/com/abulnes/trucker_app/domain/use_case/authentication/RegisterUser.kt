package com.abulnes.trucker_app.domain.use_case.authentication

import com.abulnes.trucker_app.domain.repository.AuthRepository
import javax.inject.Inject

class RegisterUser @Inject constructor(private val authRepository: AuthRepository) {

    suspend operator fun invoke(name: String, email: String, password: String): Result<Boolean>{
        return authRepository.createUserWithEmailAndPassword(name, email, password)
    }
}