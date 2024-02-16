package com.abulnes.trucker_app.presentation.screens.auth.sign_in

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.presentation.components.atoms.AppCheckbox
import com.abulnes.trucker_app.presentation.components.atoms.ButtonTypes
import com.abulnes.trucker_app.presentation.components.atoms.Input
import com.abulnes.trucker_app.presentation.components.atoms.Logo
import com.abulnes.trucker_app.presentation.components.atoms.MainButton
import com.abulnes.trucker_app.presentation.components.atoms.Screen
import com.abulnes.trucker_app.presentation.components.lifecycle.ObserveAsEvent
import com.abulnes.trucker_app.presentation.components.molecules.SpacerText
import com.abulnes.trucker_app.presentation.components.organisms.GoogleButton
import com.abulnes.trucker_app.presentation.theme.Spacing
import com.abulnes.trucker_app.utils.UiEvent

@Composable
fun SignInScreen(
    onSignIn: () -> Unit,
    onClickForgotPassword: () -> Unit,
    onClickSignUp: () -> Unit,
    snackBarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val context = LocalContext.current

    ObserveAsEvent(flow = viewModel.uiEvent) { event ->
        when (event) {
            is UiEvent.ShowSnackBar -> {
                snackBarHostState.showSnackbar(event.message.asString(context))
            }
            is UiEvent.Success -> onSignIn()
            else -> Unit
        }
    }



    Screen(modifier = modifier, arrangement = Arrangement.SpaceAround, withScroll = true) {
        Logo()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxHeight(0.8f)
        ) {
            Text(
                text = stringResource(id = R.string.login_to_your_account),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(Spacing.md))
            Input(
                value = state.email,
                onValueChange = { viewModel.onEvent(SignInEvent.OnEmailChange(it)) },
                placeholder = {
                    Text(text = stringResource(id = R.string.email))
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = null)
                },
                error = state.emailError,
                textError = stringResource(id = R.string.invalid_email)
            )
            Spacer(modifier = Modifier.height(Spacing.md))
            Input(
                value = state.password,
                onValueChange = { viewModel.onEvent(SignInEvent.OnPasswordChange(it)) },
                placeholder = {
                    Text(text = stringResource(id = R.string.password))
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = null)
                },
                trailingIcon = {
                    IconButton(onClick = { viewModel.onEvent(SignInEvent.OnShowPassword(!state.showPassword)) }) {
                        Icon(
                            imageVector = if (state.showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = stringResource(id = R.string.show_password)
                        )
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                visualTransformation = if (state.showPassword) VisualTransformation.None else PasswordVisualTransformation(
                    mask = '\u25CF'
                ),
            )
            Spacer(modifier = Modifier.height(Spacing.md))
            AppCheckbox(
                onChecked = { viewModel.onEvent(SignInEvent.OnRememberMeChange(it)) },
                text = R.string.remember_me,
                textFontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(Spacing.md))
            if (state.loading) {
                CircularProgressIndicator()
            } else {
                MainButton(
                    text = R.string.sign_in,
                    onClick = { viewModel.onEvent(SignInEvent.OnSignIn) })
            }

            MainButton(
                type = ButtonTypes.PRIMARY_TEXT,
                text = R.string.forgot_password,
                onClick = onClickForgotPassword
            )
            SpacerText(
                text = R.string.or_continue_with,
                fraction = 0.25f,
                modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                GoogleButton(
                    modifier = Modifier.fillMaxWidth(0.35f),
                    onHandleSignIn = {
                        if(it != null){
                            onSignIn()
                        }
                    }
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = R.string.dont_have_account),
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.bodyMedium
                )
                MainButton(
                    type = ButtonTypes.PRIMARY_TEXT,
                    text = R.string.sign_up,
                    onClick = onClickSignUp,
                )
            }
        }
    }
}

