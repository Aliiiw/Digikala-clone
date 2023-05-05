package com.alirahimi.digikalaclone.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.navigation.Screen
import com.alirahimi.digikalaclone.ui.components.RoundedIconBox
import com.alirahimi.digikalaclone.ui.theme.LocalSpacing
import com.alirahimi.digikalaclone.ui.theme.amber
import com.alirahimi.digikalaclone.ui.theme.grayCategory
import com.alirahimi.digikalaclone.util.Constants.DIGIJET_URL
import com.alirahimi.digikalaclone.util.Constants.DIGIMONTHSHOP_URL
import com.alirahimi.digikalaclone.util.Constants.DIGIPAY_URL
import com.alirahimi.digikalaclone.util.Constants.DIGIPINDO_URL
import com.alirahimi.digikalaclone.util.Constants.DIGIPLUS_URL
import com.alirahimi.digikalaclone.util.Constants.GIFTCARD_URL
import com.alirahimi.digikalaclone.util.Constants.MORE_URL
import com.alirahimi.digikalaclone.util.Constants.SHOPPING_STYLE_URL

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
                    url = DIGIJET_URL
                )
            )

            RoundedIconBox(
                title = stringResource(id = R.string.digi_style),
                image = painterResource(id = R.drawable.auction),
                onClick = onBoxCaseClick(
                    navController = navController,
                    url = SHOPPING_STYLE_URL
                )
            )

            RoundedIconBox(
                title = stringResource(id = R.string.digi_pay),
                image = painterResource(id = R.drawable.digipay),
                onClick = onBoxCaseClick(
                    navController,
                    url = DIGIPAY_URL
                )
            )

            RoundedIconBox(
                title = stringResource(id = R.string.digi_pindo),
                image = painterResource(id = R.drawable.pindo),
                backgroundColor = MaterialTheme.colors.amber,
                onClick = onBoxCaseClick(
                    navController,
                    url = DIGIPINDO_URL
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
                onClick = onBoxCaseClick(
                    navController,
                    url = DIGIMONTHSHOP_URL
                )
            )

            RoundedIconBox(
                title = stringResource(id = R.string.gift_card),
                image = painterResource(id = R.drawable.giftcard),
                onClick = onBoxCaseClick(
                    navController,
                    url = GIFTCARD_URL
                )
            )

            RoundedIconBox(
                title = stringResource(id = R.string.digi_plus),
                image = painterResource(id = R.drawable.digiplus),
                onClick = onBoxCaseClick(
                    navController,
                    url = DIGIPLUS_URL
                )
            )

            RoundedIconBox(
                title = stringResource(id = R.string.digi_more),
                image = painterResource(id = R.drawable.more),
                backgroundColor = MaterialTheme.colors.grayCategory,
                onClick = onBoxCaseClick(
                    navController,
                    url = MORE_URL
                )
            )
        }
    }
}

@Composable
fun onBoxCaseClick(navController: NavHostController, url: String): () -> Unit =
    { navController.navigate(route = Screen.WebView.route + "?url=${url}") }
