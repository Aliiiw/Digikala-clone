package com.alirahimi.digikalaclone.ui.screens.basket


import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.ui.theme.digikalaLightRed
import com.alirahimi.digikalaclone.ui.theme.digikalaRed
import com.alirahimi.digikalaclone.ui.theme.spacing
import com.alirahimi.digikalaclone.viewmodel.BasketViewModel

@Composable
fun BasketScreen(navController: NavHostController) {
    Basket(navController = navController)
}

@Composable
fun Basket(viewModel: BasketViewModel = hiltViewModel(), navController: NavHostController) {

    val currentBasketItemsCount = viewModel.currentBasketItemsCount.collectAsState(0)
    val nextBasketItemsCount = viewModel.nextBasketItemsCount.collectAsState(0)

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    val tabTitles = listOf(
        stringResource(id = R.string.basket_title),
        stringResource(id = R.string.next_baaket_title)
    )

    if (isSystemInDarkTheme()) {
        Column {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium),
                contentColor = MaterialTheme.colors.digikalaRed,
                indicator = { line ->
                    Box(
                        modifier = Modifier
                            .tabIndicatorOffset(line[selectedTabIndex])
                            .height(3.dp)
                        //.background(Color.Red)
                    )
                }
            ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = (selectedTabIndex == index),
                        onClick = { selectedTabIndex = index },
                        selectedContentColor = MaterialTheme.colors.digikalaLightRed,
                        unselectedContentColor = Color.Gray,
                        text = {
                            Row {
                                Text(
                                    text = title,
                                    style = MaterialTheme.typography.h6,
                                    fontWeight = FontWeight.SemiBold
                                )

                                val basketCounter =
                                    if (index == 0) currentBasketItemsCount.value else nextBasketItemsCount.value

                                if (basketCounter > 0) {
                                    Spacer(modifier = Modifier.width(10.dp))
                                    SetBadgeToTab(
                                        selectedIndex = selectedTabIndex,
                                        index = index,
                                        basketCounter = basketCounter
                                    )
                                }
                            }
                        }
                    )
                }
            }

            when (selectedTabIndex) {
                0 -> ShoppingCart(navController = navController)
                1 -> NextShoppingCart(navController = navController)
            }
        }
    } else {
        Column {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium),
                contentColor = MaterialTheme.colors.digikalaLightRed,
                backgroundColor = Color.White,
                indicator = { line ->
                    Box(
                        modifier = Modifier
                            .tabIndicatorOffset(line[selectedTabIndex])
                            .height(3.dp)
                        //.background(Color.Red)
                    )
                }
            ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = (selectedTabIndex == index),
                        onClick = { selectedTabIndex = index },
                        selectedContentColor = MaterialTheme.colors.digikalaLightRed,
                        unselectedContentColor = Color.Gray,
                        text = {
                            Row {
                                Text(
                                    text = title,
                                    style = MaterialTheme.typography.h6,
                                    fontWeight = FontWeight.SemiBold
                                )

                                val basketCounter =
                                    if (index == 0) currentBasketItemsCount.value else nextBasketItemsCount.value

                                if (basketCounter > 0) {
                                    Spacer(modifier = Modifier.width(10.dp))
                                    SetBadgeToTab(
                                        selectedIndex = selectedTabIndex,
                                        index = index,
                                        basketCounter = basketCounter
                                    )
                                }
                            }
                        }
                    )
                }
            }

            when (selectedTabIndex) {
                0 -> ShoppingCart(navController = navController)
                1 -> NextShoppingCart(navController = navController)
            }
        }
    }
}