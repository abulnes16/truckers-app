package com.abulnes.trucker_app.navigation.home

import androidx.navigation.NavController

fun NavController.navigateToHome(){
    this.navigate(Events.route)
}

fun NavController.navigateWithBottomBar(route: String) {
    this.navigate(route) {
        this.popUpTo(route) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}