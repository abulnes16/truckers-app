package com.abulnes.trucker_app

import android.app.Application
import com.abulnes.trucker_app.presentation.utils.authentication.GoogleAuthUiClient
import com.google.android.gms.auth.api.identity.Identity
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TruckerAppApplication: Application() {

    companion object {
        lateinit var googleAuthUiClient: GoogleAuthUiClient


    }
    override fun onCreate() {
        super.onCreate()
        googleAuthUiClient = GoogleAuthUiClient(this, Identity.getSignInClient(this))
    }
}