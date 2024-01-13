package com.abulnes.trucker_app.presentation.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.presentation.theme.Spacing
import com.abulnes.trucker_app.presentation.theme.TruckerAppTheme
import com.abulnes.trucker_app.presentation.theme.input_background_color
import com.abulnes.trucker_app.presentation.theme.md_theme_light_errorContainer

import com.abulnes.trucker_app.presentation.theme.md_theme_light_secondaryContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    inputModifier: Modifier = Modifier,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    error: Boolean = false,
    textError: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    keyboardActions: KeyboardActions = KeyboardActions(),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = true,
    maxNumberLines: Int = 1
) {

    var isFocus by remember {
        mutableStateOf(false)
    }



    Column(modifier = modifier.padding(horizontal = 24.dp)) {
        OutlinedTextField(
            value = value,
            isError = error,
            onValueChange = onValueChange,
            placeholder = placeholder,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            shape = RoundedCornerShape(12.dp),
            modifier = inputModifier
                .fillMaxWidth()
                .onFocusChanged {
                    isFocus = it.isFocused
                },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                containerColor =  when {
                    error -> MaterialTheme.colorScheme.errorContainer
                    isFocus -> MaterialTheme.colorScheme.secondaryContainer
                    else -> input_background_color
                },
                focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
                focusedTrailingIconColor = MaterialTheme.colorScheme.primary,
                errorLeadingIconColor = MaterialTheme.colorScheme.error,
                errorLabelColor = MaterialTheme.colorScheme.onError,
            ),
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            visualTransformation = visualTransformation,
            singleLine = singleLine,
            maxLines = maxNumberLines
            )

        if (error) {
            Spacer(modifier = Modifier.height(Spacing.xxsm))
            Text(
                text = textError,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun InputPreview() {
    TruckerAppTheme {
        Input(
            value = "", onValueChange = {},
            placeholder = {
                Text(text = stringResource(id = R.string.email))
            },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Email, contentDescription = null)
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun InputPreviewWithError() {
    TruckerAppTheme {
        Input(
            value = "", onValueChange = {},
            placeholder = {
                Text(text = stringResource(id = R.string.email))
            },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Email, contentDescription = null)
            },
            error = true,
            textError = "An error occurred"
        )
    }
}

