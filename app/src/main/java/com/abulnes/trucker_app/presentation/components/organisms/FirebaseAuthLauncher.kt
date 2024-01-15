package com.abulnes.trucker_app.presentation.components.organisms

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.IntentSender
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.abulnes.trucker_app.presentation.utils.authentication.GoogleAuthUiClient
import com.abulnes.trucker_app.presentation.utils.authentication.SignInResult
import kotlinx.coroutines.launch
import javax.inject.Inject

@Composable
fun rememberGoogleAuthLauncher(
    googleAuthUiClient: GoogleAuthUiClient?,
    resultHandler: (SignInResult?) -> Unit
): ManagedActivityResultLauncher<IntentSenderRequest, ActivityResult> {
    val scope = rememberCoroutineScope()
    return rememberLauncherForActivityResult(contract = ActivityResultContracts.StartIntentSenderForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            scope.launch {
                val signInResult = googleAuthUiClient?.signInWithIntent(
                    intent = result.data ?: return@launch
                )
                resultHandler(signInResult)
            }
        }
    }
}