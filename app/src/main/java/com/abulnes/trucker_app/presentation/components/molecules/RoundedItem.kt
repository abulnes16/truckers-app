package com.abulnes.trucker_app.presentation.components.molecules

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.presentation.components.atoms.CircleIcon
import com.abulnes.trucker_app.presentation.theme.TruckerAppTheme

@Composable
fun RoundedItem(
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier,
    @StringRes label: Int? = null,
    subtitle: String? = null,
    border: BorderStroke? = null,
    circleSize: Int = 60,
    iconSize: Int = 30,
    rowModifier: Modifier = Modifier,
) {

    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(32.dp),
        border = border,
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Row(
            modifier = rowModifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircleIcon(icon = icon, circleSize = circleSize, iconSize = iconSize)
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
            ) {
                if (label != null) {
                    Text(
                        text = stringResource(id = label),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )

                if (subtitle != null) {
                    Text(text = subtitle, style = MaterialTheme.typography.bodySmall)
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun RoundedItemPreview() {
    TruckerAppTheme {
        RoundedItem(
            icon = Icons.Filled.Email,
            label = R.string.via_email,
            text = "angel_bulnes16@yahoo.com"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RoundedItemPreviewWithSubtitle() {
    TruckerAppTheme {
        RoundedItem(
            icon = Icons.Filled.LocationOn,
            text = "Grand Park, New York City, US",
            subtitle = "Grand City St. 100, New York United States",
        )
    }
}