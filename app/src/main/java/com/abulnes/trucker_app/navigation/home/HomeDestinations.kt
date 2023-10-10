package com.abulnes.trucker_app.navigation.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument

interface HomeDestinations {
    val route: String
    val title: String?
    val icon: ImageVector?
}



object Events : HomeDestinations {
    override val route: String = "Events"
    override val title: String = "Home"
    override val icon: ImageVector = Icons.Filled.Home
}

object Profile : HomeDestinations {
    override val route: String = "Profile"
    override val title: String = "Profile"
    override val icon: ImageVector = Icons.Filled.AccountCircle
}

object MyEvents : HomeDestinations {
    override val route: String = "MyEvents"
    override val title: String? = null
    override val icon: ImageVector? = null
}


object Map : HomeDestinations {
    override val route: String = "Map"
    override val title: String = "Explore"
    override val icon: ImageVector = Icons.Filled.Place
}

object Search : HomeDestinations {
    override val route: String = "Search"
    override val title: String? = null
    override val icon: ImageVector? = null
}

object EventDetail : HomeDestinations {
    override val route: String = "EventDetail"
    override val title: String? = null
    const val routeWithArgs: String = "details/{eventId}"
    override val icon: ImageVector? = null
    const val argName = "eventId"
    val arguments = listOf(
        navArgument(argName) {
            type = NavType.StringType
            require(true)
        }
    )
}
object About : HomeDestinations {
    override val route: String = "About"
    override val title: String? = null
    override val icon: ImageVector? = null
}

object Notifications: HomeDestinations {
    override val route: String = "Notifications"
    override val title: String? = null
    override val icon: ImageVector? = null
}

val homeNavigationBarItems = listOf(Events, Map, Profile)