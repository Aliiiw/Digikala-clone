package com.alirahimi.digikalaclone.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.navigation.Screen
import com.alirahimi.digikalaclone.ui.components.RoundedIconBox
import com.alirahimi.digikalaclone.ui.theme.LocalSpacing
import com.alirahimi.digikalaclone.ui.theme.amber
import com.alirahimi.digikalaclone.ui.theme.grayCategory

@Composable
fun ShowCaseSection(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(
                horizontal = LocalSpacing.current.semiMedium,
                vertical = LocalSpacing.current.bigSmall
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LocalSpacing.current.semiSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RoundedIconBox(
                title = stringResource(id = R.string.digikala_jet),
                image = painterResource(id = R.drawable.digijet),
                onClick = onBoxCaseClick(
                    navController = navController,
                    url = "https://www.digikalajet.com/user/address"
                )
            )

            RoundedIconBox(
                title = stringResource(id = R.string.digi_style),
                image = painterResource(id = R.drawable.auction),
                onClick = onBoxCaseClick(
                    navController = navController,
                    url = "https://www.digistyle.com/sale-landing/?utm_source=digikala&utm_medium=circle_badge&utm_campaign=style&promo_name=style&promo_position=circle_badge"
                )
            )

            RoundedIconBox(
                title = stringResource(id = R.string.digi_pay),
                image = painterResource(id = R.drawable.digipay),
                onClick = onBoxCaseClick(
                    navController,
                    url = "https://www.digikala.com/my-digipay/?promo_name=my-digipay&promo_position=circle_badge"
                )
            )

            RoundedIconBox(
                title = stringResource(id = R.string.digi_pindo),
                image = painterResource(id = R.drawable.pindo),
                backgroundColor = MaterialTheme.colors.amber,
                onClick = onBoxCaseClick(
                    navController,
                    url = "https://www.pindo.ir/?utm_source=digikala&utm_medium=circle_badge&utm_campaign=pindo&promo_name=pindo&promo_position=circle_badge"
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LocalSpacing.current.semiSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RoundedIconBox(
                title = stringResource(id = R.string.digi_shopping),
                image = painterResource(id = R.drawable.shopping),
                onClick = {}
            )

            RoundedIconBox(
                title = stringResource(id = R.string.gift_card),
                image = painterResource(id = R.drawable.giftcard),
                onClick = onBoxCaseClick(
                    navController,
                    url = "https://www.digikala.com/landing/gift-card-landing/?promo_name=gift_landing&promo_position=circle_badge"
                )
            )

            RoundedIconBox(
                title = stringResource(id = R.string.digi_plus),
                image = painterResource(id = R.drawable.digiplus),
                onClick = onBoxCaseClick(
                    navController,
                    url = "https://www.digikala.com/plus/landing/?promo_name=plus&promo_position=circle_badge"
                )
            )

            RoundedIconBox(
                title = stringResource(id = R.string.digi_more),
                image = painterResource(id = R.drawable.more),
                backgroundColor = MaterialTheme.colors.grayCategory,
                onClick = {}
            )
        }
    }
}

@Composable
fun onBoxCaseClick(navController: NavHostController, url: String): () -> Unit =
    { navController.navigate(route = Screen.WebView.route + "?url=${url}") }
