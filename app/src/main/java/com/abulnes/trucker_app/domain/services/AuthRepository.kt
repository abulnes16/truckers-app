package com.abulnes.trucker_app.domain.services

import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun createUserWithEmailAndPassword(name: String, email: String, password: String): Result<Boolean>
    suspend fun authenticate(email: String, password: String)
    suspend fun signInWithProvider(provider: String)

}
