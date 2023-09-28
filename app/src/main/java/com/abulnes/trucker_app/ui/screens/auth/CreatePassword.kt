package com.abulnes.trucker_app.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.ui.components.atoms.AppCheckbox
import com.abulnes.trucker_app.ui.components.atoms.Input
import com.abulnes.trucker_app.ui.components.atoms.MainButton
import com.abulnes.trucker_app.ui.components.atoms.Screen
import com.abulnes.trucker_app.ui.components.molecules.AppTopBar
import com.abulnes.trucker_app.ui.theme.TruckerAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePasswordScreen(
    onGoBack: () -> Unit,
    onResetPassword: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier, topBar = {
        AppTopBar(
            title = R.string.create_new_password,
            canNavigateUp = true,
            onGoBack = onGoBack
        )
    }) {
        Screen(modifier = modifier.padding(it), arrangement = Arrangement.SpaceAround) {
            Image(
                painter = painterResource(id = R.drawable.create_new_password),
                contentDescription = stringResource(
                    id = R.string.accessibility_create_password
                ),
                modifier = Modifier.size(300.dp)
            )

            Column(verticalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = stringResource(R.string.create_your_new_password),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 24.dp, bottom = 12.dp)
                )

                Input(
                    value = "",
                    onValueChange = {},
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Lock, contentDescription = null)
                    },
                    placeholder = {
                        Text(text = stringResource(id = R.string.new_password))
                    },
                )
                Input(
                    value = "",
                    onValueChange = {},
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Lock, contentDescription = null)
                    },
                    placeholder = {
                        Text(text = stringResource(id = R.string.confirm_new_password))
                    },
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AppCheckbox(onChecked = {}, text = R.string.remember_me)
                }

            }

            MainButton(onClick = onResetPassword, text = R.string.continue_button)
        }
    }
}

@Preview
@Composable
fun CreatePasswordScreenPreview() {
    TruckerAppTheme {
        CreatePasswordScreen({}, {})
    }

}