package com.alirahimi.digikalaclone.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.data.model.home.StoreProduct
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.ui.theme.darkCyan
import com.alirahimi.digikalaclone.ui.theme.darkText
import com.alirahimi.digikalaclone.ui.theme.spacing
import com.alirahimi.digikalaclone.viewmodel.HomeViewModel

@Composable
fun MostFavoriteProductsSection(viewModel: HomeViewModel = hiltViewModel()) {
    var loading by remember {
        mutableStateOf(false)
    }

    var mostFavoriteList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }

    val mostFavoriteResult by viewModel.mostFavoriteItemsFlow.collectAsState()

    when (mostFavoriteResult) {

        is NetworkResult.Success -> {
            mostFavoriteList = mostFavoriteResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e(
                "2323",
                "Most Favorite Result error: ${mostFavoriteResult.message}"
            )
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.small)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = MaterialTheme.spacing.extraSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.most_favorite_product),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.darkText
            )

            Text(
                text = stringResource(id = R.string.see_all),
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.darkCyan
            )
        }

        LazyRow {
            items(
                count = mostFavoriteList.size,
                key = {
                    mostFavoriteList[it]._id
                },
                itemContent = { index ->
                    val data = mostFavoriteList[index]
                    MostFavoriteProductsOfferCard(item = data)
                }
            )

//            items(mostFavoriteList) { item ->
//                MostFavoriteProductsOfferCard(item = item)
//            }

//            item {
//                MostFavoriteProductsShowMoreCard()
//            }

            items(
                count = 1,
                itemContent = {
                    MostFavoriteProductsShowMoreCard()
                }
            )
        }
    }
}