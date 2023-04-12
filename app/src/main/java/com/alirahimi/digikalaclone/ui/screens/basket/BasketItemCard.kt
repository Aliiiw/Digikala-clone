package com.alirahimi.digikalaclone.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.alirahimi.digikalaclone.data.model.basket.BasketItem
import com.alirahimi.digikalaclone.ui.theme.spacing
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.ui.theme.darkText
import com.alirahimi.digikalaclone.ui.theme.extraSmall
import com.alirahimi.digikalaclone.ui.theme.semiDarkText
import com.alirahimi.digikalaclone.util.DigitHelper.digitByLocateAndSeparator

@Composable
fun BasketItemCard(item: BasketItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = MaterialTheme.spacing.extraSmall)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.spacing.medium)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = stringResource(id = R.string.superMarketArcitles),
                        style = MaterialTheme.typography.h3,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.darkText
                    )

                    Text(
                        text = "${digitByLocateAndSeparator("1")} کالا",
                        style = MaterialTheme.typography.h6,
                        color = Color.Gray
                    )
                }

                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "",
                    tint = MaterialTheme.colors.darkText
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(item.image),
                    contentDescription = "",
                    modifier = Modifier
                        .width(130.dp)
                        .height(90.dp)
                        .weight(0.3f)
                )

                Column(modifier = Modifier.weight(0.7f)) {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colors.darkText,
                        maxLines = 2,
                        modifier = Modifier.padding(MaterialTheme.spacing.extraSmall)
                    )

                    DetailRow(
                        icon = painterResource(id = R.drawable.in_stock),
                        text = "گارانتی اصالت",
                        color = Color.Red
                    )
                    DetailRow(
                        icon = painterResource(id = R.drawable.in_stock),
                        text = "گارانتی اصالت",
                        color = Color.Red
                    )
                    DetailRow(
                        icon = painterResource(id = R.drawable.in_stock),
                        text = "گارانتی اصالت",
                        color = Color.Red
                    )
                    DetailRow(
                        icon = painterResource(id = R.drawable.in_stock),
                        text = "گارانتی اصالت",
                        color = Color.Red
                    )
                    DetailRow(
                        icon = painterResource(id = R.drawable.in_stock),
                        text = "گارانتی اصالت",
                        color = Color.Red
                    )
                }
            }
        }
    }
}

@Composable
private fun DetailRow(
    icon: Painter, text: String, color: Color
) {
    Row(
        Modifier.padding(MaterialTheme.spacing.extraSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = icon,
            contentDescription = "",
            modifier = Modifier.size(16.dp),
            tint = color
        )

        Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))

        Text(
            text = text,
            style = MaterialTheme.typography.extraSmall,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.semiDarkText
        )
    }
}