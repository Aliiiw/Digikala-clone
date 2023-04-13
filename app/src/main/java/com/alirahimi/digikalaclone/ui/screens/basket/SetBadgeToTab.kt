package com.alirahimi.digikalaclone.ui.screens.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.alirahimi.digikalaclone.ui.theme.digikalaRed
import com.alirahimi.digikalaclone.ui.theme.spacing
import com.alirahimi.digikalaclone.util.DigitHelper.digitByLocateAndSeparator

@Composable
fun SetBadgeToTab(
    selectedIndex: Int, index: Int, basketCounter: Int
) {
    Card(modifier = Modifier.background(Color.Transparent)) {

        var color = Color.Gray
        if (selectedIndex == index) {
            color = MaterialTheme.colors.digikalaRed
        }

        Text(
            text = digitByLocateAndSeparator(basketCounter.toString()),
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .background(color = color)
                .padding(horizontal =  MaterialTheme.spacing.semiSmall)
        )
    }

}
