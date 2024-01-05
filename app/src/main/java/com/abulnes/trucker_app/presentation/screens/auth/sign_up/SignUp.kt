package com.abulnes.trucker_app.presentation.screens.auth.sign_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.presentation.components.atoms.AppCheckbox
import com.abulnes.trucker_app.presentation.components.atoms.ButtonTypes
import com.abulnes.trucker_app.presentation.components.atoms.Input
import com.abulnes.trucker_app.presentation.components.atoms.Logo
import com.abulnes.trucker_app.presentation.components.atoms.MainButton
import com.abulnes.trucker_app.presentation.components.atoms.Screen
import com.abulnes.trucker_app.presentation.components.molecules.SpacerText
import com.abulnes.trucker_app.presentation.theme.Spacing
import com.abulnes.trucker_app.presentation.theme.TruckerAppTheme
import com.abulnes.trucker_app.utils.UiEvent
import kotlinx.coroutines.flow.collect

@Composable
fun SignUpScreen(
    onSignUp: () -> Unit,
    onClickSignIn: () -> Unit,
    snackBarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    snackBarHostState.showSnackbar(event.message.asString(context))
                }

                is UiEvent.Success -> {

                }

                else -> Unit
            }

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
                text = stringResource(id = R.string.create_new_account),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(Spacing.md))
            Input(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(id = R.string.name))
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = null)
                }
            )
            Input(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(id = R.string.email))
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = null)
                }
            )
            Input(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(id = R.string.password))
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = null)
                }
            )

            Spacer(modifier = Modifier.height(Spacing.md))
            AppCheckbox(
                onChecked = {},
                text = R.string.remember_me,
                textFontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(Spacing.md))

            MainButton(text = R.string.sign_up, onClick = onSignUp)
            SpacerText(
                text = R.string.or_continue_with,
                fraction = 0.25f,
                modifier = Modifier.padding(top = 24.dp, bottom = 12.dp)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                MainButton(
                    modifier = Modifier.fillMaxWidth(0.35f),
                    type = ButtonTypes.OUTLINE,
                    onClick = {}
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google_logo),
                        contentDescription = stringResource(
                            id = R.string.accessibility_google_logo
                        ),
                        modifier = Modifier
                            .width(25.dp)
                            .height(25.dp)
                    )
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = R.string.already_have_account),
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.bodyMedium
                )
                MainButton(
                    type = ButtonTypes.PRIMARY_TEXT,
                    text = R.string.sign_in,
                    onClick = onClickSignIn
                )
            }
        }
    }
}