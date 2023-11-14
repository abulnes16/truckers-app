package com.abulnes.trucker_app.navigation.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.abulnes.trucker_app.ui.screens.home.AboutScreen
import com.abulnes.trucker_app.ui.screens.home.EventDetailScreen
import com.abulnes.trucker_app.ui.screens.home.EventsScreen
import com.abulnes.trucker_app.ui.screens.home.MapScreen
import com.abulnes.trucker_app.ui.screens.home.MyEventsScreen
import com.abulnes.trucker_app.ui.screens.home.NotificationsScreen
import com.abulnes.trucker_app.ui.screens.home.ProfileScreen
import com.abulnes.trucker_app.ui.screens.home.SearchScreen

const val HOME_ROUTE = "home"
fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation(startDestination = Events.route, route = HOME_ROUTE) {
        composable(Events.route) {
            EventsScreen(
                onClickNavItem = { route -> navController.navigateWithBottomBar(route) },
                onClickSearch = { navController.navigateToSearch() }
            )
        }
        composable(EventDetail.route) {
            EventDetailScreen()
        }
        composable(Map.route) {
            MapScreen()
        }
        composable(Search.route) {
            SearchScreen()
        }

        composable(Profile.route) {
            ProfileScreen()
        }

        composable(MyEvents.route) {
            MyEventsScreen()
        }

        composable(About.route) {
            AboutScreen()
        }
        composable(Notifications.route) {
            NotificationsScreen()
        }
    }
}