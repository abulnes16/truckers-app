package com.abulnes.trucker_app.presentation.screens.auth.welcome

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.abulnes.trucker_app.presentation.utils.authentication.SignInResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class WelcomeViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(WelcomeState())
        private set


    fun onSignInResult(result: SignInResult?) {
       state = state.copy(signInSuccessful = result?.data !== null, errorMessage = result?.errorMessage)
    }

}