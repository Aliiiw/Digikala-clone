package com.alirahimi.digikalaclone.ui.screens.basket

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
import androidx.hilt.navigation.compose.hiltViewModel
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.data.model.basket.BasketItem
import com.alirahimi.digikalaclone.data.model.basket.CartStatus
import com.alirahimi.digikalaclone.ui.theme.darkText
import com.alirahimi.digikalaclone.ui.theme.spacing
import com.alirahimi.digikalaclone.viewmodel.BasketViewModel

@Composable
fun ShoppingCart(viewModel: BasketViewModel = hiltViewModel()) {


    val currentBasketItemsState: BasketScreenState<List<BasketItem>>
            by viewModel.currentBasketItems.collectAsState(BasketScreenState.Loading)


    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 60.dp)
    ) {

        when (currentBasketItemsState) {
            is BasketScreenState.Success -> {
                if ((currentBasketItemsState as BasketScreenState.Success<List<BasketItem>>).data.isEmpty()) {
                    item { EmptyBasketShopping() }
                    item { SuggestListSection() }
                } else {
                    items((currentBasketItemsState as BasketScreenState.Success<List<BasketItem>>).data) { item ->
                        BasketItemCard(item = item, status = CartStatus.CURRENT_CART)
                    }
                }
            }

            is BasketScreenState.Loading -> {
                item {
                    val config = LocalConfiguration.current
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(config.screenHeightDp.dp - 60.dp)
                            .padding(vertical = MaterialTheme.spacing.small),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.please_wait),
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.h5,
                            color = MaterialTheme.colors.darkText
                        )
                    }
                }
            }

            is BasketScreenState.Error -> {
                item {
                    Text(text = "Error")
                }
            }
        }
    }
}