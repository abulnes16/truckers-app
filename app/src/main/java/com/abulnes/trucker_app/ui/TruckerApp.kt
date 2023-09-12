package com.abulnes.trucker_app.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abulnes.trucker_app.navigation.TruckerAppNavHost
import com.abulnes.trucker_app.ui.theme.TruckerAppTheme


@Composable
fun TruckerApp(modifier: Modifier = Modifier) {
    TruckerAppTheme {
        TruckerAppNavHost(modifier)
    }
}

@Preview
@Composable
fun TruckerAppPreview() {
    TruckerApp()
}