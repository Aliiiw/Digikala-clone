package com.alirahimi.digikalaclone.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.alirahimi.digikalaclone.data.model.home.AmazingItem
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.ui.theme.*
import com.alirahimi.digikalaclone.util.DigitHelper.applyDiscount
import com.alirahimi.digikalaclone.util.DigitHelper.digitByLocate
import com.alirahimi.digikalaclone.util.DigitHelper.digitByLocateAndSeparator

@Composable
fun AmazingItem(item: AmazingItem) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .padding(
                vertical = MaterialTheme.spacing.semiLarge,
                horizontal = MaterialTheme.spacing.semiSmall
            ),
        shape = MaterialTheme.roundedShape.small
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.small)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = MaterialTheme.spacing.extraSmall)
            ) {
                Text(
                    text = stringResource(id = R.string.amazing_for_app),
                    modifier = Modifier.padding(MaterialTheme.spacing.small),
                    style = MaterialTheme.typography.extraSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.digikalaLightRed
                )

                Spacer(modifier = Modifier.height(10.dp))

                Image(
                    painter = rememberAsyncImagePainter(item.image),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp),
                    contentScale = ContentScale.FillBounds
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = MaterialTheme.spacing.small)
            ) {
                Text(
                    text = item.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .height(48.dp)
                        .padding(horizontal = MaterialTheme.spacing.small),
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.darkText,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .size(22.dp)
                            .padding(2.dp),
                        painter = painterResource(id = R.drawable.in_stock),
                        contentDescription = "",
                        tint = MaterialTheme.colors.darkCyan
                    )

                    Text(
                        text = item.seller,
                        style = MaterialTheme.typography.extraSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colors.semiDarkText
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = MaterialTheme.spacing.small),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(24.dp)
                            .background(
                                color = MaterialTheme.colors.digikalaDarkRed,
                                shape = CircleShape
                            )
                            .wrapContentWidth(Alignment.CenterHorizontally)
                            .wrapContentHeight(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = "${digitByLocate(item.discountPercent.toString())} %",
                            color = Color.White,
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Column {
                        Row {
                            Text(
                                text = digitByLocateAndSeparator(
                                    applyDiscount(
                                        item.price,
                                        item.discountPercent
                                    ).toString()
                                ),
                                style = MaterialTheme.typography.body2,
                                fontWeight = FontWeight.SemiBold
                            )

                            Image(
                                painter = painterResource(id = R.drawable.toman),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(MaterialTheme.spacing.semiLarge)
                                    .padding(horizontal = MaterialTheme.spacing.extraSmall)
                            )
                        }
                        Text(
                            text = digitByLocateAndSeparator(item.price.toString()),
                            color = Color.LightGray,
                            style = MaterialTheme.typography.body2,
                            textDecoration = TextDecoration.LineThrough
                        )
                    }
                }
            }
        }
    }
}