package com.abulnes.trucker_app.domain.preferences

interface Preferences {

    fun saveUserSession(rememberSession: Boolean)

    fun loadUserSession(): Boolean

    companion object {
        const val USER_SESSION_KEY = "save_user_session"
    }

}