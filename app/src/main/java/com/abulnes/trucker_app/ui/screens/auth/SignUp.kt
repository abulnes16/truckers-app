package com.abulnes.trucker_app.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.ui.components.atoms.ButtonTypes
import com.abulnes.trucker_app.ui.components.atoms.Input
import com.abulnes.trucker_app.ui.components.atoms.MainButton
import com.abulnes.trucker_app.ui.components.atoms.Screen
import com.abulnes.trucker_app.ui.components.molecules.SpacerText
import com.abulnes.trucker_app.ui.theme.TruckerAppTheme
import com.abulnes.trucker_app.ui.theme.input_background_color

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    Screen(modifier = modifier, arrangement = Arrangement.SpaceAround) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
            )
        }
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

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = true,
                    onCheckedChange = {},
                )
                Text(text = stringResource(id = R.string.remember_me), fontWeight = FontWeight.Bold)
            }
            MainButton(text = R.string.sign_up, onClick = {})
            SpacerText(
                text = R.string.or_continue_with,
                fraction = 0.25f,
                modifier = Modifier.padding(top = 24.dp)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                MainButton(
                    onClick = {},
                    type = ButtonTypes.OUTLINE,
                    modifier = Modifier.fillMaxWidth(0.35f)
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
                    color = MaterialTheme.colorScheme.outline
                )
                MainButton(text = R.string.sign_in, type = ButtonTypes.PRIMARY_TEXT, onClick = {})
            }
        }


    }
}


@Preview
@Composable
fun SignUpScreenPreview() {
    TruckerAppTheme {
        SignUpScreen()
    }

}