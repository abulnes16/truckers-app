package com.abulnes.trucker_app.presentation.components.organisms

import androidx.activity.result.IntentSenderRequest
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.TruckerAppApplication
import com.abulnes.trucker_app.presentation.components.atoms.ButtonTypes
import com.abulnes.trucker_app.presentation.components.atoms.MainButton
import com.abulnes.trucker_app.presentation.theme.Spacing
import com.abulnes.trucker_app.presentation.theme.urbanistFontFamily
import com.abulnes.trucker_app.presentation.utils.authentication.GoogleAuthUiClient
import com.abulnes.trucker_app.presentation.utils.authentication.SignInResult
import kotlinx.coroutines.launch


@Composable
fun GoogleButton(
    onHandleSignIn: (SignInResult?) -> Unit,
    modifier: Modifier = Modifier,
    imageSize: Dp = 20.dp,
    text: Int? = null
) {


    val coroutineScope = rememberCoroutineScope()
    val launcher =
        rememberGoogleAuthLauncher(
            googleAuthUiClient = TruckerAppApplication.googleAuthUiClient,
            resultHandler = onHandleSignIn
        )


    MainButton(
        type = ButtonTypes.OUTLINE,
        onClick = {
            coroutineScope.launch {
                val signInIntentSender = TruckerAppApplication.googleAuthUiClient.signIn()
                launcher.launch(
                    IntentSenderRequest.Builder(
                        signInIntentSender ?: return@launch
                    ).build()
                )
            }
        },
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.google_logo),
            contentDescription = stringResource(id = R.string.accessibility_google_logo),
            modifier = Modifier
                .width(imageSize)
                .height(imageSize)
        )
        if (text !== null) {
            Spacer(modifier = Modifier.width(Spacing.xsm))
            Text(
                text = stringResource(id = text),
                fontFamily = urbanistFontFamily,
                fontWeight = FontWeight.Bold,
                
            )
        }
    }
}

