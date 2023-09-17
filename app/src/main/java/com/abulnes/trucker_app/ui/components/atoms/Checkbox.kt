package com.abulnes.trucker_app.ui.components.atoms

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes.trucker_app.R
import com.abulnes.trucker_app.ui.theme.TruckerAppTheme

@Composable
fun AppCheckbox(
    onChecked: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    initialCheckedValue: Boolean? = null,
    @StringRes text: Int? = null,
    textFontWeight: FontWeight? = FontWeight.Normal
) {
    var isChecked by remember {
        mutableStateOf(initialCheckedValue ?: false)
    }

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Card(
            modifier = Modifier
                .background(Color.Transparent),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(width = 3.dp, color = MaterialTheme.colorScheme.primary)
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(if (isChecked) MaterialTheme.colorScheme.primary else Color.White)
                    .clickable {
                        isChecked = !isChecked
                        onChecked(isChecked)
                    },
                contentAlignment = Alignment.Center
            ) {
                if (isChecked) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(15.dp)
                    )
                }
            }


        }
        if (text != null) {
            Text(
                text = stringResource(id = text),
                modifier = Modifier.padding(start = 8.dp),
                fontWeight = textFontWeight
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun AppCheckboxPreview() {
    TruckerAppTheme {
        AppCheckbox({})
    }
}

@Preview(showBackground = true)
@Composable
fun AppCheckboxTextPreview() {
    TruckerAppTheme {
        AppCheckbox({}, text = R.string.remember_me)
    }
}