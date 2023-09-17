package com.abulnes.trucker_app.ui.components.atoms

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.R

@Composable
fun Logo(modifier: Modifier = Modifier, logoModifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = logoModifier
                .width(200.dp)
                .height(200.dp)
        )
    }

}

@Preview
@Composable
fun LogoPreview() {
    Logo()
}