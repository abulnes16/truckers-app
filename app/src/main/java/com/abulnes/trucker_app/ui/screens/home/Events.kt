package com.abulnes.trucker_app.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.data.entities.mockEvents
import com.abulnes.trucker_app.data.entities.popularMockEvents
import com.abulnes.trucker_app.ui.components.atoms.CircleImage
import com.abulnes.trucker_app.ui.components.atoms.Input
import com.abulnes.trucker_app.ui.components.molecules.EventItem
import com.abulnes.trucker_app.ui.components.molecules.SectionTitle
import com.abulnes.trucker_app.ui.components.organisms.BottomNavigationBar
import com.abulnes.trucker_app.ui.theme.TruckerAppTheme


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun EventsScreen(
    onClickNavItem: (String) -> Unit,
    onClickSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier.padding(horizontal = 28.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircleImage(
                    image = R.drawable.user,
                    modifier = Modifier
                        .size(30.dp)
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
        LazyColumn(
            modifier = Modifier
                .padding(it)
        ) {
            item {
                Input(
                    value = "",
                    onValueChange = {},
                    leadingIcon = {
                        IconButton(onClick = onClickSearch) {
                            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                        }
                    },
                    trailingIcon = {
                        IconButton(onClick = onClickSearch) {
                            Icon(
                                imageVector = Icons.Filled.List,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }

                    },
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.events_search_placeholder),
                            color = MaterialTheme.colorScheme.outlineVariant,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.clickable { onClickSearch() }
                        )
                    }
                )
            }
            item {
                SectionTitle(
                    title = R.string.featured,
                    actionText = R.string.see_all,
                    onClickAction = { /*TODO*/ }
                )
            }




            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {

                    items(popularMockEvents) { event ->
                        EventItem(
                            name = event.name,
                            date = event.date,
                            hour = event.hour,
                            image = R.drawable.concert,
                            location = "Grand Park, New York"
                        )
                    }
                }
            }







            item {
                SectionTitle(
                    title = R.string.popular_event,
                    actionText = R.string.see_all,
                    onClickAction = { /*TODO*/ }
                )
            }

            item {

                FlowRow(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(
                        16.dp,
                        Alignment.CenterHorizontally
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    maxItemsInEachRow = 2,
                ) {

                    mockEvents.forEach { event ->
                        EventItem(
                            name = event.name,
                            date = event.date,
                            hour = event.hour,
                            image = R.drawable.artjpg,
                            location = "Grand Park, New York",
                            modifier = Modifier.width(180.dp),
                            imageModifier = Modifier
                                .width(150.dp)
                                .height(150.dp)
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
        EventsScreen({}, {})
    }

}