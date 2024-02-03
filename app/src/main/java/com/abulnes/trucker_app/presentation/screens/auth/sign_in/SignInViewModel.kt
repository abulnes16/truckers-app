package com.abulnes.trucker_app.presentation.screens.auth.sign_in

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.domain.preferences.Preferences
import com.abulnes.trucker_app.domain.use_case.authentication.AuthenticationUseCases
import com.abulnes.trucker_app.domain.use_case.validators.ValidatorsUseCases
import com.abulnes.trucker_app.utils.UiEvent
import com.abulnes.trucker_app.utils.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authenticationUseCases: AuthenticationUseCases,
    private val preferences: Preferences,
    private val validatorsUseCases: ValidatorsUseCases
) : ViewModel() {

    var state by mutableStateOf(SignInState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: SignInEvent) {
        when (event) {
            is SignInEvent.OnEmailChange -> {
                val isEmailValid = validatorsUseCases.validateEmail(event.email)
                state = state.copy(email = event.email, emailError = !isEmailValid)
            }

            is SignInEvent.OnPasswordChange -> {
                val isPasswordValid = validatorsUseCases.validatePassword(event.password)
                state = state.copy(password = event.password, passwordError = !isPasswordValid)
            }

            is SignInEvent.OnRememberMeChange -> {
                preferences.saveUserSession(event.rememberMe)
            }

            is SignInEvent.OnShowPassword -> {
                state = state.copy(showPassword = event.showPassword)
            }

            is SignInEvent.OnSignIn -> {
                onSignIn()
            }
        }
    }

    private fun onSignIn() {
        viewModelScope.launch {
            state = state.copy(loading = true)
            val isFormValid =
                validatorsUseCases.validateSignIn(
                    email = state.email,
                    password = state.password
                )

            if(!isFormValid){
                _uiEvent.send(UiEvent.ShowSnackBar(UiText.StringResource(R.string.invalid_sign_in_form)))
                state = state.copy(loading = false)
                return@launch
            }

             authenticationUseCases.authenticate(email = state.email, password = state.password)
                 .onSuccess {
                     state = state.copy(loading = false)
                     _uiEvent.send(UiEvent.Success)
                 }
                 .onFailure {
                     _uiEvent.send(UiEvent.ShowSnackBar(UiText.StringResource(R.string.falied_sign_in)))
                     state = state.copy(loading = false)
                 }
        }
    }

}