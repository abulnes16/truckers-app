package com.abulnes.trucker_app.ui.components.atoms

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.ui.theme.TruckerAppTheme

@Composable
fun CircleImage(@DrawableRes image: Int,modifier: Modifier = Modifier) {
    Image(
        painterResource(id = image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(
                CircleShape
            )
    )
}

@Preview
@Composable
fun CircleImagePreview() {
    TruckerAppTheme {
        CircleImage(image = R.drawable.user, modifier = Modifier.size(30.dp))
    }
}