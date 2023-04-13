package com.alirahimi.digikalaclone.ui.screens.profile

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.alirahimi.digikalaclone.ui.theme.*

@Composable
fun ProfileEditText(
    value: String,
    onValueChange: () -> Unit,
    placeHolder: String
) {

    TextField(

        value = value,
        onValueChange = { onValueChange() },
        modifier = Modifier
            .fillMaxWidth()
            .height(92.dp)
            .padding(
                start = MaterialTheme.spacing.semiLarge,
                end = MaterialTheme.spacing.semiLarge,
                top = MaterialTheme.spacing.medium,
                bottom = MaterialTheme.spacing.semiLarge
            ),
        shape = MaterialTheme.roundedShape.small,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.searchBarBackground,
            focusedIndicatorColor = MaterialTheme.colors.darkCyan,
            unfocusedIndicatorColor = MaterialTheme.colors.searchBarBackground,
            cursorColor = MaterialTheme.colors.cursorColor
        ),
        placeholder = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = placeHolder,
                    style = MaterialTheme.typography.h6,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    )
}