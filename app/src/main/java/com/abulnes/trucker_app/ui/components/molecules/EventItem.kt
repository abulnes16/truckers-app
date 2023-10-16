package com.abulnes.trucker_app.ui.components.molecules

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.ui.theme.TruckerAppTheme

@Composable
fun EventItem(
    name: String,
    @DrawableRes image: Int,
    date: String,
    hour: String,
    location: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = image),
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
                text = name,
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "$date  $hour",
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
                    text = location,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }
    }
}

@Preview
@Composable
fun EventItemPreview() {
    TruckerAppTheme {
        EventItem(
            name = "National Music Festival",
            date = "Mon, Dec 24",
            hour = "18:00 - 23:00 PM",
            image = R.drawable.concert,
            location = "Grand Park, New York"
        )
    }

}