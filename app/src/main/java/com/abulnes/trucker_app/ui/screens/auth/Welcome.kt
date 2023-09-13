package com.abulnes.trucker_app.ui.screens.auth

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abulnes.trucker_app.ui.theme.TruckerAppTheme

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
    Text(text = "Hello world")
}


@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    TruckerAppTheme {
        WelcomeScreen()
    }

}