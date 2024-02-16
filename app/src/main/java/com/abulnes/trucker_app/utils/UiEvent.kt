package com.abulnes.trucker_app.utils


sealed class UiEvent {
    object Success: UiEvent()
    data class SuccessWithSnackBar(val message: UiText): UiEvent()
    object NavigateUp: UiEvent()
    data class ShowSnackBar(val message: UiText): UiEvent()

    data class ShowValidateInputError(val errorMessage: UiText): UiEvent()
}
