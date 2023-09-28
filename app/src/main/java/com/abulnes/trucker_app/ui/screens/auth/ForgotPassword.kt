package com.abulnes.trucker_app.ui.screens.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.navigation.auth.ForgotPassword
import com.abulnes.trucker_app.ui.components.atoms.MainButton
import com.abulnes.trucker_app.ui.components.atoms.Screen
import com.abulnes.trucker_app.ui.components.molecules.AppTopBar
import com.abulnes.trucker_app.ui.components.molecules.RoundedItem
import com.abulnes.trucker_app.ui.theme.TruckerAppTheme
import com.abulnes.trucker_app.ui.theme.md_theme_light_outlineVariant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(
    onGoBack: () -> Unit,
    onCreatePassword: () -> Unit,
    modifier: Modifier = Modifier
) {

    var recoveryMethodSelected by remember {
        mutableStateOf("")
    }

    var borderWidth by remember {
        mutableStateOf(1.dp)
    }

    var borderColor by remember {
        mutableStateOf(md_theme_light_outlineVariant)
    }

    if (recoveryMethodSelected == "email") {
        borderWidth = 3.dp
        borderColor = MaterialTheme.colorScheme.primary
    } else {
        borderWidth = 1.dp
        borderColor = MaterialTheme.colorScheme.outlineVariant
    }

    Scaffold(topBar = {
        AppTopBar(
            title = R.string.forgot_password_title,
            canNavigateUp = true,
            onGoBack = onGoBack
        )
    }) { padding ->
        Screen(
            modifier.padding(padding)
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
                Text(text = stringResource(id = R.string.select_recovery_method))
                RoundedItem(
                    icon = Icons.Filled.Email,
                    label = R.string.via_email,
                    text = "angel_bulnes16@yahoo.com",
                    border = BorderStroke(
                        width = borderWidth,
                        color = borderColor
                    ),
                    modifier = Modifier.clickable {
                        recoveryMethodSelected = "email"
                    }
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(bottom = 16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                MainButton(text = R.string.continue_button, onClick = onCreatePassword)
            }


        }
    }


}


@Preview
@Composable
fun ForgotPasswordScreenPreview() {
    TruckerAppTheme {
        ForgotPasswordScreen({},{})
    }

}