package com.abulnes.trucker_app.ui.components.organisms

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.abulnes.trucker_app.navigation.home.Events
import com.abulnes.trucker_app.navigation.home.homeNavigationBarItems
import com.abulnes.trucker_app.ui.theme.TruckerAppTheme

@Composable
fun BottomNavigationBar(onClickNavItem: (String) -> Unit, modifier: Modifier = Modifier) {
    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    var currentRoute by remember {
        mutableStateOf(Events.route)
    }



    homeNavigationBarItems.forEachIndexed { index, navItem ->

        if (navItem.route == currentRoute) {
            selectedItem = index
        }
    }

    NavigationBar(modifier, containerColor = Color.White) {
        homeNavigationBarItems.forEachIndexed { index, homeDestinations ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    currentRoute = homeDestinations.route
                    onClickNavItem(homeDestinations.route)
                },
                icon = {
                    Icon(
                        imageVector = homeDestinations.icon!!,
                        contentDescription = null,
                        tint = if (selectedItem == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
                    )
                },
                label = {
                    Text(
                        text = homeDestinations.title!!,
                        color = if (selectedItem == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
                    )
                }
            )
        }
    }

}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    TruckerAppTheme {
        BottomNavigationBar({ })
    }

}