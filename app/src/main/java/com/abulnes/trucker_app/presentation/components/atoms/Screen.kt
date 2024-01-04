package com.abulnes.trucker_app.presentation.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Screen(
    modifier: Modifier = Modifier,
    alignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    arrangement: Arrangement.Vertical = Arrangement.Top,
    withScroll: Boolean = false,
    content: @Composable () -> Unit
) {

    val screenModifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)

    if (withScroll) {
        Column(
            modifier = screenModifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = alignment,
            verticalArrangement = arrangement
        ) {
            content()
        }
    } else {
        Column(
            modifier = screenModifier,
            horizontalAlignment = alignment,
            verticalArrangement = arrangement,
        ) {
            content()
        }
    }




}