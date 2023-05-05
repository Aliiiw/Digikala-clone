package com.alirahimi.digikalaclone.ui.screens.basket

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.ui.theme.*
import com.alirahimi.digikalaclone.util.DigitHelper.digitByLocateAndSeparator

@Composable
fun BuyProcessContinue(price: Long) {

    Card(
        shape = MaterialTheme.roundedShape.extraSmall,
        elevation = MaterialTheme.elevation.extraSmall,
        border = BorderStroke(1.dp, Color.LightGray.copy(0.2f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = MaterialTheme.spacing.medium,
                    vertical = MaterialTheme.spacing.semiMedium
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.digikalaLightRed
                ),
                modifier = Modifier,
                shape = MaterialTheme.roundedShape.small
            ) {
                Text(
                    text = stringResource(id = R.string.purchase_process),
                    color = Color.White,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(
                        horizontal = MaterialTheme.spacing.bigMedium,
                        vertical = MaterialTheme.spacing.extraSmall,
                    )
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.goods_total_price),
                    color = MaterialTheme.colors.semiDarkText,
                    style = MaterialTheme.typography.h6
                )

                Row {
                    Text(
                        text = digitByLocateAndSeparator(price.toString()),
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.SemiBold
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.toman), contentDescription = "",
                        modifier = Modifier
                            .size(MaterialTheme.spacing.semiLarge)
                            .padding(horizontal = MaterialTheme.spacing.extraSmall)
                    )
                }
            }
        }
    }
}