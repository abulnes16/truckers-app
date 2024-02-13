package com.abulnes.trucker_app.domain.repository

import com.abulnes.trucker_app.domain.models.User
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun createUserWithEmailAndPassword(name: String, email: String, password: String): Result<Boolean>
    suspend fun authenticate(email: String, password: String): Result<User>
    suspend fun signInWithProvider(provider: String)

    suspend fun recoverPassword(email: String): Result<Boolean>

}
