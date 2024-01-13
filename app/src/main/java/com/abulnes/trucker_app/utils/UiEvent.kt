package com.abulnes.trucker_app.utils

import com.abulnes.trucker_app.presentation.screens.auth.sign_up.SignUpEvent

sealed class UiEvent {
    object Success: UiEvent()
    object NavigateUp: UiEvent()
    data class ShowSnackBar(val message: UiText): UiEvent()

    data class ShowValidateInputError(val errorMessage: UiText): UiEvent()
}
