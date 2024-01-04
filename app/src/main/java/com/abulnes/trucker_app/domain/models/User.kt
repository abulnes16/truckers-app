package com.abulnes.trucker_app.domain.models

data class User(
    var email: String,
    var firstname: String,
    var lastname: String,
    var dateOfBirth: String,
    var gender: String,
    var profilePicture: String,
)
