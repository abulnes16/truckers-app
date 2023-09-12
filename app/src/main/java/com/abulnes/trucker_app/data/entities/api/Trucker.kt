package com.abulnes.trucker_app.data.entities.api

data class Trucker(
    val id: String,
    val name: String,
    val isCheckIn: Boolean = false,
    val checkInDate: String,
)
