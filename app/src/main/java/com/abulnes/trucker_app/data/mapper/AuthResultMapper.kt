package com.abulnes.trucker_app.data.mapper

import com.abulnes.trucker_app.domain.models.User
import com.google.firebase.auth.AuthResult

fun AuthResult.toUser(): User {
    val email = this.user?.email ?: ""
    val photoUrl = this.user?.photoUrl.toString()
    val name = this.user?.displayName ?: ""

    return User(
        email = email,
        profilePicture = photoUrl,
        firstname = name,
        lastname = name,
        gender = "",
        dateOfBirth = "",
    )
}