package com.abulnes.trucker_app.data.repository


import android.util.Log
import com.abulnes.trucker_app.data.mapper.toUser
import com.abulnes.trucker_app.domain.models.User
import com.abulnes.trucker_app.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import kotlin.Exception


const val AUTH_REPOSITORY_TAG = "[AuthRepository]"

class AuthRepositoryImpl @Inject constructor(private val firebaseAuth: FirebaseAuth) :
    AuthRepository {

    override val currentUser: FirebaseUser? = firebaseAuth.currentUser
    override suspend fun createUserWithEmailAndPassword(
        name: String,
        email: String,
        password: String
    ): Result<Boolean> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            result.user?.updateProfile(
                UserProfileChangeRequest.Builder().setDisplayName(name).build()
            )?.await()
            Result.success(true)
        } catch (e: Exception) {
            Log.e(AUTH_REPOSITORY_TAG, e.message ?: "Auth Error")
            Result.failure(e)
        }
    }

    override suspend fun authenticate(email: String, password: String): Result<User> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            val user = result.toUser()
            Result.success(user)
        } catch (e: Exception) {
            Log.e(AUTH_REPOSITORY_TAG, e.message ?: "Auth Error")
            Result.failure(e)
        }
    }

    override suspend fun signInWithProvider(provider: String) {
        TODO("Not yet implemented")
    }

    override suspend fun recoverPassword(email: String): Result<Boolean> {
        return try {
            firebaseAuth.sendPasswordResetEmail(email).await()
            Result.success(true)
        }catch (e: Exception){
            Log.e(AUTH_REPOSITORY_TAG, e.message ?: "Recover Password Error")
            Result.failure(e)
        }
    }
}