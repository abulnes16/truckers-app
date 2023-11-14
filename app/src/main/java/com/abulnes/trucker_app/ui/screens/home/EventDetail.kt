package com.abulnes.trucker_app.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.ui.components.atoms.Badge
import com.abulnes.trucker_app.ui.components.atoms.CircleImage
import com.abulnes.trucker_app.ui.components.atoms.MainButton
import com.abulnes.trucker_app.ui.components.atoms.Screen
import com.abulnes.trucker_app.ui.components.molecules.RoundedItem
import com.abulnes.trucker_app.ui.theme.Spacing
import com.abulnes.trucker_app.ui.theme.TruckerAppTheme

@Composable
fun EventDetailScreen(modifier: Modifier = Modifier) {

    Box() {
        Screen(modifier = modifier, withScroll = true, alignment = Alignment.Start) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(340.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.concert),
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize(),
                        contentDescription = null
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Spacing.normal, vertical = Spacing.lg),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                        Row {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Filled.FavoriteBorder,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Filled.Send,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                        }

                    }
                }
            }


            Column(
                modifier = Modifier.padding(
                    horizontal = Spacing.normal,
                    vertical = Spacing.md
                )
            ) {
                Column(modifier = Modifier.padding(bottom = Spacing.md)) {
                    Text(
                        text = "National Music Festival",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Row(modifier = Modifier.padding(top = Spacing.md)) {
                        Badge(text = "Music")
                    }
                }
                Divider(
                    modifier = Modifier.fillMaxWidth(0.95f),
                    color = MaterialTheme.colorScheme.outlineVariant
                )
                Column(
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier.padding(vertical = Spacing.custom(2))
                ) {
                    RoundedItem(
                        icon = Icons.Filled.DateRange,
                        text = "Monday, December 24, 2022",
                        subtitle = "18:00 - 23:00 OM (GMT +07:00)",
                        iconSize = 25,
                        circleSize = 50,
                        modifier = Modifier.padding(vertical = Spacing.normal)
                    )
                    RoundedItem(
                        icon = Icons.Filled.LocationOn,
                        text = "Grand Park, New York City, US",
                        subtitle = "Grand City St. 100, New York, United States",
                        iconSize = 25,
                        circleSize = 50,
                        modifier = Modifier.padding(bottom = Spacing.normal)
                    )
                }
                Divider(
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(bottom = Spacing.md),
                    color = MaterialTheme.colorScheme.outlineVariant
                )

                Row(modifier = Modifier.padding(bottom = Spacing.normal)) {
                    CircleImage(
                        image = R.drawable.artjpg,
                        modifier = Modifier
                            .size(50.dp)

                    )
                    Column(modifier = Modifier.padding(start = Spacing.normal)) {
                        Text(text = "World of Music", style = MaterialTheme.typography.titleSmall)
                        Text(text = "Organizer", style = MaterialTheme.typography.labelLarge)
                    }
                }

                Column(modifier = Modifier.padding(bottom = Spacing.md)) {
                    Text(
                        text = stringResource(id = R.string.about_event),
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(bottom = Spacing.sm)
                    )
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }


                Column {
                    Text(
                        text = stringResource(id = R.string.location),
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(bottom = Spacing.sm)
                    )
                    Row {
                        Icon(
                            imageVector = Icons.Filled.LocationOn,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Grand City St. 100, New York, United States",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }


            }


        }
        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            shadowElevation = 8.dp,
            color = Color.White
        ) {
            MainButton(
                text = R.string.book_event,
                onClick = {},
                modifier = Modifier.padding(vertical = Spacing.normal)
            )
        }
    }


}


@Preview
@Composable
fun EventDetailScreenPreview() {
    TruckerAppTheme {
        EventDetailScreen()
    }

}