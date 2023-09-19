package com.abulnes.trucker_app.ui.components.molecules

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.ui.theme.TruckerAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    @StringRes title: Int,
    canNavigateUp: Boolean,
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = stringResource(id = title)) },
        navigationIcon = {
            if (canNavigateUp) {
                IconButton(onClick = onGoBack) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            }
        }, modifier = modifier
    )
}

@Preview
@Composable
fun AppTopBarPreview() {
    TruckerAppTheme {
        AppTopBar(title = R.string.forgot_password_title, canNavigateUp = false, {})
    }
}

@Preview
@Composable
fun AppTopBarWithBackPreview() {
    TruckerAppTheme {
        AppTopBar(title = R.string.forgot_password_title, canNavigateUp = true, onGoBack = {})
    }
}