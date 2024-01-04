package com.abulnes.trucker_app.domain.models

data class Comment(
    val username: String,
    var content: String,
    var rating: Int,
)
