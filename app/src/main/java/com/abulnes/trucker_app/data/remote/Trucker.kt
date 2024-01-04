package com.abulnes.trucker_app.data.remote

data class Trucker(
    val id: String,
    val name: String,
    val isCheckIn: Boolean = false,
    val checkInDate: String,
)
