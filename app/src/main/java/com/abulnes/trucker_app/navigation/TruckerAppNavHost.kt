package com.abulnes.trucker_app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.abulnes.trucker_app.navigation.auth.AUTH_ROUTE
import com.abulnes.trucker_app.navigation.auth.authGraph
import com.abulnes.trucker_app.navigation.home.homeGraph

@Composable
fun TruckerAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = AUTH_ROUTE, modifier = modifier) {
        authGraph(navController)
        homeGraph(navController)
    }
}