package com.abulnes.trucker_app.ui.components.molecules

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.R

@Composable
fun SpacerText(
    @StringRes text: Int,
    fraction: Float,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth(1f)
    ) {
        Divider(modifier = Modifier.fillMaxWidth(fraction))
        Text(
            text = stringResource(id = text),
            textAlign = TextAlign.Center,
            modifier = textModifier.padding(horizontal = 8.dp),
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.outline
        )
        Divider(modifier = Modifier.fillMaxWidth(fraction * 2))

    }
}

@Preview(showBackground = true)
@Composable
fun SpacerTextPreview() {
    SpacerText(text = R.string.or_continue_with, fraction = 0.25f)
}

@Preview(showBackground = true)
@Composable
fun SpacerTextPreviewShort() {
    SpacerText(text = R.string.or, fraction = 0.4f)
}