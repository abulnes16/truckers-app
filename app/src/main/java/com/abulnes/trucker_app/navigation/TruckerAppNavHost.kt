package com.abulnes.trucker_app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.abulnes.trucker_app.navigation.auth.AUTH_ROUTE
import com.abulnes.trucker_app.navigation.auth.authGraph
import com.abulnes.trucker_app.navigation.home.homeGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TruckerAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    val snackBarState = remember {
        SnackbarHostState()
    }
    Scaffold(snackbarHost = { SnackbarHost(snackBarState) }) {
        NavHost(
            navController = navController,
            startDestination = AUTH_ROUTE,
            modifier = modifier.padding(it)
        ) {
            authGraph(navController, snackBarState)
            homeGraph(navController)
        }
    }
}