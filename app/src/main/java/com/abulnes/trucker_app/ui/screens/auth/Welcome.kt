package com.abulnes.trucker_app.ui.screens.auth

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.ui.components.atoms.ButtonTypes
import com.abulnes.trucker_app.ui.components.atoms.MainButton
import com.abulnes.trucker_app.ui.components.atoms.Screen
import com.abulnes.trucker_app.ui.components.molecules.SpacerText
import com.abulnes.trucker_app.ui.theme.TruckerAppTheme
import com.abulnes.trucker_app.ui.theme.urbanistFontFamily

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
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
            MainButton(
                type = ButtonTypes.OUTLINE,
                onClick = { /*TODO*/ },
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google_logo),
                    contentDescription = stringResource(id = R.string.accessibility_google_logo),
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .width(20.dp)
                        .height(20.dp)
                )
                Text(
                    text = stringResource(id = R.string.continue_with_google),
                    fontFamily = urbanistFontFamily,
                    fontWeight = FontWeight.Bold,
                )

            }
            SpacerText(text = R.string.or, fraction = 0.4f)
            MainButton(onClick = { /*TODO*/ }, text = R.string.sign_in_with_password)

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = R.string.dont_have_account),
                    color = MaterialTheme.colorScheme.outline
                )
                MainButton(
                    onClick = { /*TODO*/ },
                    type = ButtonTypes.PRIMARY_TEXT,
                    text = R.string.sign_up
                )
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    TruckerAppTheme {
        WelcomeScreen()
    }
}