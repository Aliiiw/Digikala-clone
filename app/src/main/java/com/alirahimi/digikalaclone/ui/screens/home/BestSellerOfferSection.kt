package com.alirahimi.digikalaclone.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.data.model.home.StoreProduct
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.ui.theme.darkText
import com.alirahimi.digikalaclone.ui.theme.spacing
import com.alirahimi.digikalaclone.util.DigitHelper.digitByLocateAndSeparator
import com.alirahimi.digikalaclone.viewmodel.HomeViewModel

@Composable
fun BestSellerOfferSection(viewModel: HomeViewModel = hiltViewModel()) {
    var loading by remember {
        mutableStateOf(false)
    }

    var bestSellerList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }

    val bestSellerResult by viewModel.bestSellerItemsFlow.collectAsState()

    when (bestSellerResult) {

        is NetworkResult.Success -> {
            bestSellerList = bestSellerResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e(
                "2323",
                "Best Seller Result error: ${bestSellerResult.message}"
            )

        }

        is NetworkResult.Loading -> {
            loading = true

        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.small)
    ) {
        Text(
            text = stringResource(id = R.string.best_selling_product),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText
        )

        LazyHorizontalGrid(
            rows = GridCells.Fixed(3),
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.medium)
                .height(250.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            itemsIndexed(bestSellerList) { index, item ->
                ProductHorizontalCard(
                    name = item.name,
                    id = digitByLocateAndSeparator((index + 1).toString()),
                    imageUrl = item.image
                )
            }
        }
    }
}