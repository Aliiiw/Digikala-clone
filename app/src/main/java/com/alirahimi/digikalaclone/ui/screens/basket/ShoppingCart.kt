package com.alirahimi.digikalaclone.ui.screens.basket

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.datastore.dataStore
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.data.model.basket.BasketItem
import com.alirahimi.digikalaclone.data.model.basket.CartStatus
import com.alirahimi.digikalaclone.navigation.Screen
import com.alirahimi.digikalaclone.ui.theme.darkText
import com.alirahimi.digikalaclone.ui.theme.spacing
import com.alirahimi.digikalaclone.util.Constants
import com.alirahimi.digikalaclone.util.Constants.USER_TOKEN
import com.alirahimi.digikalaclone.viewmodel.BasketViewModel

@Composable
fun ShoppingCart(
    navController: NavController,
    viewModel: BasketViewModel = hiltViewModel()
) {

    val basketDetail = viewModel.basketDetail.collectAsState()

    val currentBasketItemsState: BasketScreenState<List<BasketItem>> by viewModel.currentBasketItems
        .collectAsState(BasketScreenState.Loading)

    var isCartEmpty by remember {
        mutableStateOf(true)
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 60.dp),
        ) {

            item {
                if (Constants.USER_TOKEN == "null") {
                    LoginOrRegisterSection(navController = navController)
                }
            }

            when (currentBasketItemsState) {
                is BasketScreenState.Success -> {
                    if ((currentBasketItemsState as BasketScreenState.Success<List<BasketItem>>).data.isEmpty()) {
                        isCartEmpty = true
                        item { EmptyBasketShopping() }
                        item { SuggestListSection() }
                    } else {

                        isCartEmpty = false

                        items((currentBasketItemsState as BasketScreenState.Success<List<BasketItem>>).data) { item ->
                            BasketItemCard(item, CartStatus.CURRENT_CART)
                        }

                        item {
                            BasketPriceDetailSection(basketDetail.value)
                        }
                    }
                }
                is BasketScreenState.Loading -> {
                    item {
                        Column(
                            modifier = Modifier
                                .height(LocalConfiguration.current.screenHeightDp.dp - 60.dp)
                                .fillMaxWidth()
                                .padding(vertical = MaterialTheme.spacing.small),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = stringResource(R.string.please_wait),
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.h5,
                                color = MaterialTheme.colors.darkText,
                            )
                        }
                    }
                }
                is BasketScreenState.Error -> {
                    Log.e("2323", "err")
                }
            }
        }
        if (!isCartEmpty) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 60.dp)
            ) {
                BuyProcessContinue(basketDetail.value.payablePrice) {
                    if (USER_TOKEN == "null") {
                        navController.navigate(Screen.Profile.route)
                    } else {
                        navController.navigate(Screen.CheckOut.route)
                    }
                }
            }
        }

    }

}