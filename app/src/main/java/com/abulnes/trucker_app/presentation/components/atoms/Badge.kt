package com.abulnes.trucker_app.presentation.components.atoms

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.presentation.theme.Spacing
import com.abulnes.trucker_app.presentation.theme.TruckerAppTheme

@Composable
fun Badge(text: String, modifier: Modifier = Modifier, textModifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(8.dp)
            ),

        ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
            modifier = textModifier.padding(
                vertical = Spacing.xxsm,
                horizontal = Spacing.xsm
            ),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview
@Composable
fun BadgePreview() {
    TruckerAppTheme {
        Badge(text = "Music")
    }
}