package com.abulnes.trucker_app.presentation.screens.auth.welcome


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.presentation.components.atoms.ButtonTypes
import com.abulnes.trucker_app.presentation.components.atoms.MainButton
import com.abulnes.trucker_app.presentation.components.atoms.Screen
import com.abulnes.trucker_app.presentation.components.molecules.SpacerText
import com.abulnes.trucker_app.presentation.components.organisms.GoogleButton
import com.abulnes.trucker_app.presentation.components.organisms.rememberGoogleAuthLauncher
import com.abulnes.trucker_app.presentation.theme.TruckerAppTheme


@Composable
fun WelcomeScreen(
    onClickSignIn: () -> Unit,
    onClickSignUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: WelcomeViewModel = hiltViewModel()
) {


    val context = LocalContext.current
    LaunchedEffect(key1 = viewModel.state.errorMessage) {
        viewModel.state.errorMessage?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }






    Screen(modifier = modifier, arrangement = Arrangement.SpaceAround) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.welcome_illustration),
                contentDescription = stringResource(
                    id = R.string.accessibility_welcome_img
                ),
                modifier = modifier
                    .width(320.dp)
                    .height(320.dp)
            )

        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxHeight(0.7f)
        ) {
            Text(
                text = stringResource(id = R.string.welcome_to_trucker_app),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            GoogleButton(
                onHandleSignIn = viewModel::onSignInResult,
                text = R.string.continue_with_google,
                googleAuthUiClient = viewModel.googleAuthUiClient
            )
            SpacerText(text = R.string.or, fraction = 0.4f)
            MainButton(text = R.string.sign_in_with_password, onClick = onClickSignIn)

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = R.string.dont_have_account),
                    color = MaterialTheme.colorScheme.outline
                )
                MainButton(
                    type = ButtonTypes.PRIMARY_TEXT,
                    text = R.string.sign_up,
                    onClick = onClickSignUp
                )
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    TruckerAppTheme {
        WelcomeScreen(onClickSignIn = {}, onClickSignUp = {})
    }
}