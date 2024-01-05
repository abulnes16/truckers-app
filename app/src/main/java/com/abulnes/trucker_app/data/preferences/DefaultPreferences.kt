package com.abulnes.trucker_app.data.preferences

import android.content.SharedPreferences
import com.abulnes.trucker_app.domain.preferences.Preferences

class DefaultPreferences(private val sharedPref: SharedPreferences) : Preferences {

    override fun saveUserSession(rememberSession: Boolean) {
        sharedPref
            .edit()
            .putBoolean(Preferences.USER_SESSION_KEY, rememberSession)
            .apply()
    }

    override fun loadUserSession(): Boolean {
        return sharedPref.getBoolean(Preferences.USER_SESSION_KEY, false)
    }
}