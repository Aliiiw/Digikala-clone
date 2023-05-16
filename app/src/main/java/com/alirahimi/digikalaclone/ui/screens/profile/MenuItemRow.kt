package com.alirahimi.digikalaclone.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.alirahimi.digikalaclone.ui.theme.settingArrow
import com.alirahimi.digikalaclone.ui.theme.spacing


@Composable
fun MenuItemRow(
    painter: Painter,
    text: String,
    isHaveDivider: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = MaterialTheme.spacing.medium)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painter,
                contentDescription = "",
                modifier = Modifier
                    .size(36.dp)
                    .padding(MaterialTheme.spacing.small)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.9f)
                .padding(horizontal = MaterialTheme.spacing.small),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )

                Icon(
                    Icons.Outlined.KeyboardArrowLeft,
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp),
                    tint = MaterialTheme.colors.settingArrow
                )
            }

            if (isHaveDivider) {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .alpha(0.4f),
                    color = Color.LightGray,
                )
            }
        }
    }
}