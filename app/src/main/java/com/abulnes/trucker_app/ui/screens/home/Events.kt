package com.abulnes.trucker_app.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.ui.components.atoms.Input
import com.abulnes.trucker_app.ui.components.atoms.Screen
import com.abulnes.trucker_app.ui.components.organisms.BottomNavigationBar
import com.abulnes.trucker_app.ui.theme.TruckerAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventsScreen(onClickNavItem: (String) -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier.padding(horizontal = 28.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(id = R.drawable.user),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(
                            CircleShape
                        )
                )
                Column(modifier = Modifier.padding(start = 12.dp)) {
                    Text(
                        text = stringResource(id = R.string.good_morning),
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(text = "Andrew Aisnley", style = MaterialTheme.typography.titleSmall)
                }
            }
        },
        bottomBar = { BottomNavigationBar(onClickNavItem = onClickNavItem) },
        modifier = modifier,
    ) {
        Screen(modifier = Modifier.padding(it), withScroll = true) {
            Input(
                value = "",
                onValueChange = {},
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.List,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.events_search_placeholder),
                        color = MaterialTheme.colorScheme.outlineVariant,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.featured),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(id = R.string.see_all),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Card(
                shape = RoundedCornerShape(32.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.width(350.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.concert),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(320.dp)
                            .height(220.dp)
                            .clip(
                                RoundedCornerShape(38.dp)
                            )
                    )
                    Text(
                        text = "National Music Festival",
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = "Mon, Dec 24  18:00 - 23:00 PM",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Row {
                        Icon(
                            imageVector = Icons.Filled.Place,
                            contentDescription = null,
                            modifier = Modifier.size(14.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Grand Park, New York",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.popular_event),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(id = R.string.see_all),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }


            Card(
                shape = RoundedCornerShape(32.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.width(150.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.artjpg),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(140.dp)
                            .height(80.dp)
                            .clip(
                                RoundedCornerShape(38.dp)
                            )
                    )
                    Text(
                        text = "Art Workshops",
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = "Mon, Dec 24  18:00 - 23:00 PM",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Row {
                        Icon(
                            imageVector = Icons.Filled.Place,
                            contentDescription = null,
                            modifier = Modifier.size(14.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Grand Park, New York",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }
            }

        }
    }
}


@Preview
@Composable
fun EventsScreenPreview() {
    TruckerAppTheme {
        EventsScreen({})
    }

}