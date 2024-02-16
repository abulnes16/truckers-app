package com.abulnes.trucker_app.presentation.screens.auth.forgot_password

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.presentation.components.atoms.Input
import com.abulnes.trucker_app.presentation.components.atoms.MainButton
import com.abulnes.trucker_app.presentation.components.atoms.Screen
import com.abulnes.trucker_app.presentation.components.lifecycle.ObserveAsEvent
import com.abulnes.trucker_app.presentation.components.molecules.AppTopBar
import com.abulnes.trucker_app.presentation.components.molecules.RoundedItem
import com.abulnes.trucker_app.presentation.screens.auth.sign_in.SignInEvent
import com.abulnes.trucker_app.presentation.theme.Spacing
import com.abulnes.trucker_app.presentation.theme.TruckerAppTheme
import com.abulnes.trucker_app.presentation.theme.md_theme_light_outlineVariant
import com.abulnes.trucker_app.utils.UiEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(
    onGoBack: () -> Unit,
    onCreatePassword: () -> Unit,
    snackBarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    viewModel: ForgotPasswordViewModel = hiltViewModel()
) {

    val state = viewModel.state
    val context = LocalContext.current

    ObserveAsEvent(flow = viewModel.uiEvent) { event ->
        when (event) {
            is UiEvent.ShowSnackBar -> {
                snackBarHostState.showSnackbar(event.message.asString(context))
            }

            is UiEvent.SuccessWithSnackBar -> {
                snackBarHostState.showSnackbar(event.message.asString(context))
                onCreatePassword()
            }

            else -> Unit
        }
    }



    Scaffold(topBar = {
        AppTopBar(
            title = R.string.forgot_password_title,
            canNavigateUp = true,
            onGoBack = onGoBack
        )
    }) { padding ->
        Screen(
            modifier.padding(padding),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.forgot_password),
                    contentDescription = stringResource(
                        id = R.string.accessibility_forgot_password
                    ),
                    modifier = Modifier.size(280.dp)
                )
            }

            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(text = stringResource(id = R.string.enter_email_for_new_password))
                Spacer(modifier = Modifier.height(Spacing.xl))
                Input(
                    value = state.email,
                    onValueChange = { viewModel.onEvent(ForgotPasswordEvent.onEmailChange(it)) },
                    placeholder = {
                        Text(text = stringResource(id = R.string.email))
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Email, contentDescription = null)
                    },
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(bottom = 16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                if (viewModel.state.loading) {
                    CircularProgressIndicator()
                } else {
                    MainButton(
                        text = R.string.send,
                        onClick = { viewModel.onEvent(ForgotPasswordEvent.OnRecoverPassword) },
                        enabled = state.isFormValid
                    )
                }

            }
        }
    }
}
