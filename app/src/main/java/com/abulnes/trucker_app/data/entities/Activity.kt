package com.abulnes.trucker_app.data.entities

data class Activity(
    val name: String,
    val description: String,
    val category: String,
    val businessName: String,
    val eventPhoto: String = "",
    val status: String,
    val globalRating: Int = 0,
    val assistants: Int = 0,
    val comments: List<Comment> = listOf(),
    val location: Location
)
