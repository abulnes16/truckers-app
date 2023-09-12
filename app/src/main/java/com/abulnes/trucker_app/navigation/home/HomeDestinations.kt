package com.abulnes.trucker_app.navigation.home

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface HomeDestinations {
    val route: String
    val title: String?
}

object Events : HomeDestinations {
    override val route: String = "Events"
    override val title: String = "Home"
}

object Profile : HomeDestinations {
    override val route: String = "Profile"
    override val title: String = "Profile"
}

object MyEvents : HomeDestinations {
    override val route: String = "MyEvents"
    override val title: String? = null
}


object Map : HomeDestinations {
    override val route: String = "Map"
    override val title: String = "Explore"
}

object Search : HomeDestinations {
    override val route: String = "Search"
    override val title: String? = null
}

object EventDetail : HomeDestinations {
    override val route: String = "EventDetail"
    override val title: String? = null
    const val routeWithArgs: String = "details/{eventId}"
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
}

object Notifications: HomeDestinations {
    override val route: String = "Notifications"
    override val title: String? = null
}