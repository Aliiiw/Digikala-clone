package com.alirahimi.digikalaclone.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.alirahimi.digikalaclone.data.model.home.AmazingItem
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.ui.theme.digikalaLightRed
import com.alirahimi.digikalaclone.viewmodel.HomeViewModel
import com.alirahimi.digikalaclone.R

@Composable
fun AmazingItemsSection(viewModel: HomeViewModel = hiltViewModel()) {

    var loading by remember {
        mutableStateOf(false)
    }

    var amazingItemList by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }

    val amazingItemResult by viewModel.amazingItemsFlow.collectAsState()

    when (amazingItemResult) {

        is NetworkResult.Success -> {
            amazingItemList = amazingItemResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("2323", "Amazing Items error: ${amazingItemResult.message}")

        }

        is NetworkResult.Loading -> {
            loading = true

        }
    }

    Column(modifier = Modifier
        .background(MaterialTheme.colors.digikalaLightRed)
        .fillMaxWidth()) {
        LazyRow(modifier = Modifier.background(MaterialTheme.colors.digikalaLightRed)) {
            item {
                AmazingOfferCard(topImageId = R.drawable.amazings, bottomImageId = R.drawable.box)
            }

            items(amazingItemList) { item ->
                AmazingItem(item = item)
            }

            item {
                AmazingShowMoreItems()
            }
        }
    }

}