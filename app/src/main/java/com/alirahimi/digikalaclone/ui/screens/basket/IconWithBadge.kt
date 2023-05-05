package com.alirahimi.digikalaclone.ui.screens.basket

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alirahimi.digikalaclone.ui.theme.*
import com.alirahimi.digikalaclone.util.DigitHelper.digitByLocateAndSeparator

@Composable
fun IconWithBadge(
    basketCounter: Int,
    icon: Painter
) {
    Box(
        modifier = Modifier
            .height(28.dp)
    ) {
        Box(
            modifier = Modifier
                .height(28.dp)
                .width(36.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Icon(
                painter = icon,
                contentDescription = "",
                modifier = Modifier
                    .height(24.dp)
            )
        }

        Box(
            modifier = Modifier
                .height(28.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Card(
                shape = MaterialTheme.roundedShape.extraSmall,
                border = BorderStroke(0.5.dp, Color.White.copy(0.8f)),
                elevation = 2.dp
            ) {
                Text(
                    text = digitByLocateAndSeparator(basketCounter.toString()),
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.digikalaLightRed)
                        .wrapContentSize()
                        .padding(
                            horizontal = MaterialTheme.spacing.small
                        ),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.extraSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}