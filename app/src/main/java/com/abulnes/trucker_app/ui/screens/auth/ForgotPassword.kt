package com.abulnes.trucker_app.ui.screens.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.abulnes.trucker_app.ui.theme.TruckerAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = {
        Text(
            text = stringResource(id = R.string.forgot_password_title),
            style = MaterialTheme.typography.titleMedium
        )
    }) { padding ->
        Screen(
            modifier.padding(padding),
            alignment = Alignment.Start,
            arrangement = Arrangement.SpaceAround
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.forgot_password),
                    contentDescription = stringResource(
                        id = R.string.accessibility_forgot_password
                    ),
                    modifier = Modifier.size(280.dp)
                )
                Text(text = stringResource(id = R.string.select_recovery_method))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    shape = RoundedCornerShape(32.dp),
                    border = BorderStroke(width = 4.dp, color = MaterialTheme.colorScheme.primary),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                ) {
                    Row(
                        modifier = Modifier.padding(24.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card(
                            shape = CircleShape,
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                contentColor = MaterialTheme.colorScheme.onSurface
                            ),
                            modifier = Modifier.size(60.dp),
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Email,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(30.dp)
                                )
                            }

                        }
                        Column(
                            modifier = Modifier
                                .padding(start = 16.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.via_email),
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.outline
                            )
                            Text(
                                text = "and***ley@yourdomain.com",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }


            MainButton(text = R.string.continue_button, onClick = {})

        }
    }


}


@Preview
@Composable
fun ForgotPasswordScreenPreview() {
    TruckerAppTheme {
        ForgotPasswordScreen()
    }

}