package com.alirahimi.digikalaclone.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.alirahimi.digikalaclone.ui.theme.darkCyan
import com.alirahimi.digikalaclone.ui.theme.darkText
import com.alirahimi.digikalaclone.ui.theme.extraBoldNumber
import com.alirahimi.digikalaclone.ui.theme.spacing

@Composable
fun ProductHorizontalCard(name: String, id: String, imageUrl: String) {

    Row(
        modifier = Modifier
            .width(320.dp)
            .padding(MaterialTheme.spacing.extraSmall),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = "",
            modifier = Modifier
                .weight(0.3f)
                .fillMaxHeight()
        )

        Text(
            text = id,
            style = MaterialTheme.typography.extraBoldNumber,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.darkCyan,
            modifier = Modifier
                .weight(0.1f)
                .padding(MaterialTheme.spacing.small)
        )

        Column(
            modifier = Modifier
                .weight(0.6f)
                .fillMaxHeight()
                .padding(MaterialTheme.spacing.small)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.darkText,
                modifier = Modifier
                    .padding(top = MaterialTheme.spacing.small),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}