package com.abulnes.trucker_app.presentation.screens.auth.sign_up

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
class SignUpViewModel @Inject constructor(
    private val authenticationUseCases: AuthenticationUseCases,
    private val preferences: Preferences,
    private val validatorsUseCases: ValidatorsUseCases
) : ViewModel() {

    var state by mutableStateOf(
        SignUpState(
            name = "",
            email = "",
            password = "",
            loading = false,
        )
    )
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.OnNameChange -> {
                state = state.copy(name = event.name, nameError = event.name.isBlank())
            }

            is SignUpEvent.OnPasswordChange -> {

                val validPassword = validatorsUseCases.validatePassword(event.password)
                state = state.copy(password = event.password, passwordError = !validPassword)
            }

            is SignUpEvent.OnEmailChange -> {
                val validEmail = validatorsUseCases.validateEmail(event.email)
                state = state.copy(email = event.email, emailError = !validEmail)
            }

            is SignUpEvent.OnShowPassword -> {
                state = state.copy(showPassword = event.show)
            }

            is SignUpEvent.OnSignUp -> {
                onSignUp()
            }



            is SignUpEvent.OnRememberUser -> {
                preferences.saveUserSession(event.rememberSession)
            }
        }
    }

    private fun onSignUp() {

        viewModelScope.launch {
            state = state.copy(loading = true)
            val isFormValid = validatorsUseCases.validateSignUp(
                name = state.name,
                email = state.email,
                password = state.password
            )

            if(!isFormValid){
                _uiEvent.send(UiEvent.ShowSnackBar(UiText.StringResource(R.string.invalid_sign_up_form)))
                state = state.copy(loading = false)
                return@launch
            }

            authenticationUseCases.registerUser(
                name = state.name,
                email = state.email,
                password = state.password
            ).onSuccess {
                state = state.copy(loading = false)
                _uiEvent.send(UiEvent.Success)

            }.onFailure {
                state = state.copy(loading = false)
                _uiEvent.send(UiEvent.ShowSnackBar(UiText.StringResource(R.string.sign_up_error)))
            }
        }
    }

}