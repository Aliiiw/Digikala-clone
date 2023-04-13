package com.alirahimi.digikalaclone.ui.screens.profile

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alirahimi.digikalaclone.ui.components.Loading3Dots
import com.alirahimi.digikalaclone.ui.theme.digikalaRed
import com.alirahimi.digikalaclone.ui.theme.roundedShape
import com.alirahimi.digikalaclone.ui.theme.spacing

@Composable
fun ProfileLoadingButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.digikalaRed
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(
                start = MaterialTheme.spacing.semiLarge,
                end = MaterialTheme.spacing.semiLarge,
                bottom = MaterialTheme.spacing.medium
            ),
        shape = MaterialTheme.roundedShape.small
    ) {
        Loading3Dots(isDark = isSystemInDarkTheme())
    }
}