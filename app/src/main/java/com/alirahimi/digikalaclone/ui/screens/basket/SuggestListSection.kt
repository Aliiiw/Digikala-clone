package com.alirahimi.digikalaclone.ui.screens.basket

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.data.model.basket.BasketItem
import com.alirahimi.digikalaclone.data.model.basket.CartStatus
import com.alirahimi.digikalaclone.data.model.home.StoreProduct
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.ui.theme.darkText
import com.alirahimi.digikalaclone.ui.theme.spacing
import com.alirahimi.digikalaclone.viewmodel.BasketViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SuggestListSection(viewModel: BasketViewModel = hiltViewModel()) {

    LaunchedEffect(true) {
        viewModel.getAllDataFromServer()
    }

    var loading by remember {
        mutableStateOf(false)
    }

    var suggestItemList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }

    val suggestItemResult by viewModel.suggestedItemsFlow.collectAsState()

    when (suggestItemResult) {

        is NetworkResult.Success -> {
            suggestItemList = suggestItemResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("2323", "Suggest Items error: ${suggestItemResult.message}")

        }

        is NetworkResult.Loading -> {
            loading = true

        }
    }

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.spacing.small)
    )

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.medium),
        text = stringResource(id = R.string.suggest_for_you),
        textAlign = TextAlign.Start,
        style = MaterialTheme.typography.h4,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colors.darkText
    )

    FlowRow(
        maxItemsInEachRow = 2,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Start
    ) {
        suggestItemList.forEach { item ->
            SuggestionItemCard(item = item) {
                viewModel.insertBasketItem(
                    BasketItem(
                        it._id,
                        it.name,
                        it.seller,
                        it.price,
                        it.discountPercent,
                        it.image,
                        1,
                        CartStatus.CURRENT_CART
                    )
                )
            }
        }
    }
}