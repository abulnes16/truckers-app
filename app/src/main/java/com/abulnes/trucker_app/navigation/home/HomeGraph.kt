package com.abulnes.trucker_app.navigation.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.abulnes.trucker_app.presentation.screens.home.about.AboutScreen
import com.abulnes.trucker_app.presentation.screens.home.event_detail.EventDetailScreen
import com.abulnes.trucker_app.presentation.screens.home.events.EventsScreen
import com.abulnes.trucker_app.presentation.screens.home.map.MapScreen
import com.abulnes.trucker_app.presentation.screens.home.my_events.MyEventsScreen
import com.abulnes.trucker_app.presentation.screens.home.notifications.NotificationsScreen
import com.abulnes.trucker_app.presentation.screens.home.profile.ProfileScreen
import com.abulnes.trucker_app.presentation.screens.home.search.SearchScreen

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