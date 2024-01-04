package com.abulnes.trucker_app.presentation.components.atoms

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.presentation.theme.TruckerAppTheme
import com.abulnes.trucker_app.presentation.theme.urbanistFontFamily

enum class ButtonTypes {
    PRIMARY, OUTLINE, SECONDARY, PRIMARY_TEXT
}

@Composable
fun ButtonContent(
    modifier: Modifier = Modifier,
    text: Int? = null,
    buttonText: String? = null,
    content: (@Composable () -> Unit)? = null,
) {
    val contentModifier = modifier.padding(8.dp)


    if (text != null || buttonText != null) {

        val renderText =
            if (text != null) stringResource(id = text) else if (buttonText !== null) buttonText else ""

        Text(
            text = renderText,
            modifier = contentModifier,
            fontFamily = urbanistFontFamily,
            fontWeight = FontWeight.Bold
        )
    }

    if (content != null) {
        Row(modifier = contentModifier, verticalAlignment = Alignment.CenterVertically) {
            content()
        }

    }
}

@Composable
fun MainButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    type: ButtonTypes = ButtonTypes.PRIMARY,
    @StringRes text: Int? = null,
    buttonText: String? = null,
    textModifier: Modifier = Modifier,
    content: @Composable() (() -> Unit)? = null
) {

    val buttonModifier = modifier
        .fillMaxWidth(1f)
        .padding(horizontal = 24.dp, vertical = 8.dp)

    when (type) {
        ButtonTypes.PRIMARY -> {
            Button(onClick = onClick, modifier = buttonModifier) {
                ButtonContent(
                    text = text,
                    buttonText = buttonText,
                    modifier = textModifier,
                    content = content
                )
            }
        }

        ButtonTypes.OUTLINE -> {
            OutlinedButton(
                onClick = onClick,
                modifier = buttonModifier,
                colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.onBackground)
            ) {
                ButtonContent(
                    text = text,
                    buttonText = buttonText,
                    modifier = textModifier,
                    content = content
                )
            }
        }

        ButtonTypes.SECONDARY -> {
            FilledTonalButton(
                onClick = onClick,
                modifier = buttonModifier,
                colors = ButtonDefaults.filledTonalButtonColors(contentColor = MaterialTheme.colorScheme.primary)
            ) {
                ButtonContent(
                    text = text,
                    buttonText = buttonText,
                    modifier = textModifier,
                    content = content
                )
            }
        }

        ButtonTypes.PRIMARY_TEXT -> {
            TextButton(onClick = onClick, modifier = modifier) {
                ButtonContent(
                    text = text,
                    buttonText = buttonText,
                    modifier = textModifier,
                    content = content
                )
            }
        }


    }


}


@Preview(showBackground = true)
@Composable
fun PrimaryButtonPreview() {
    TruckerAppTheme {
        MainButton(onClick = {}, text = R.string.sign_up)
    }
}

@Preview(showBackground = true)
@Composable
fun SecondaryButtonPreview() {
    TruckerAppTheme {
        MainButton(onClick = {}, type = ButtonTypes.SECONDARY, text = R.string.sign_up)
    }
}

@Preview(showBackground = true)
@Composable
fun OutlineButtonPreview() {
    TruckerAppTheme {
        MainButton(onClick = {}, type = ButtonTypes.OUTLINE, text = R.string.sign_up)
    }
}

@Preview(showBackground = true)
@Composable
fun PrimaryTextButtonPreview() {
    TruckerAppTheme {
        MainButton(onClick = {}, type = ButtonTypes.PRIMARY_TEXT, text = R.string.sign_up)
    }
}