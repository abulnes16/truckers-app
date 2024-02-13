package com.abulnes.trucker_app.presentation.screens.auth.forgot_password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abulnes.trucker_app.R
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
class ForgotPasswordViewModel @Inject constructor(
    private val validatorsUseCases: ValidatorsUseCases,
    private val authenticationUseCases: AuthenticationUseCases
) :
    ViewModel() {

    var state by mutableStateOf(ForgotPasswordState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: ForgotPasswordEvent) {
        when (event) {
            is ForgotPasswordEvent.onEmailChange -> {
                val isEmailValid = validatorsUseCases.validateEmail(event.email)
                state = state.copy(
                    email = event.email,
                    emailError = !isEmailValid,
                    isFormValid = isEmailValid
                )
            }

            is ForgotPasswordEvent.OnRecoverPassword -> {
                onRecoverPassword()
            }
        }
    }

    private fun onRecoverPassword() {
        viewModelScope.launch {
            state = state.copy(loading = true)
            authenticationUseCases
                .recoverPassword(email = state.email)
                .onSuccess {
                    state = state.copy(loading = false)
                    _uiEvent.send(UiEvent.Success)
                }
                .onFailure {
                    state = state.copy(loading = false)
                    _uiEvent.send(UiEvent.ShowSnackBar(UiText.StringResource(R.string.failed_sent_recovery_email)))
                }
        }
    }
}