package com.alirahimi.digikalaclone.ui.screens.basket


import androidx.compose.foundation.background
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
import com.alirahimi.digikalaclone.viewmodel.BasketViewModel
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.ui.theme.digikalaRed
import com.alirahimi.digikalaclone.ui.theme.spacing

@Composable
fun BasketScreen(navController: NavHostController) {
    Basket(navController = navController)
}

@Composable
fun Basket(viewModel: BasketViewModel = hiltViewModel(), navController: NavHostController) {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    val tabTitles = listOf(
        stringResource(id = R.string.basket_title),
        stringResource(id = R.string.next_baaket_title)
    )

    Column {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium),
            contentColor = MaterialTheme.colors.digikalaRed,
            backgroundColor = Color.White,
            indicator = { line ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(line[selectedTabIndex])
                        .height(3.dp)
                        .background(Color.Red)
                )
            }
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = (selectedTabIndex == index),
                    onClick = { selectedTabIndex = index },
                    selectedContentColor = MaterialTheme.colors.digikalaRed,
                    unselectedContentColor = Color.Gray,
                    text = {
                        Row {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.h6,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                )
            }
        }

        when (selectedTabIndex) {
            0 -> ShoppingCart()
            1 -> NextShoppingCart()
        }
    }
}