package com.alirahimi.digikalaclone.ui.screens.basket

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alirahimi.digikalaclone.data.model.basket.BasketItem
import com.alirahimi.digikalaclone.viewmodel.BasketViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ShoppingCart(viewModel: BasketViewModel = hiltViewModel()) {

    val currentBasketItems = remember {
        mutableStateOf(emptyList<BasketItem>())
    }

    LaunchedEffect(true) {
        viewModel.currentBasketItemsFlow.collectLatest { list ->
            currentBasketItems.value = list
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 60.dp)
    ) {
        if (currentBasketItems.value.isEmpty()) {
            item { EmptyBasketShopping() }
            item { SuggestListSection() }
        } else {
            items(currentBasketItems.value){item ->
                BasketItemCard(item = item)
            }
        }
    }
}