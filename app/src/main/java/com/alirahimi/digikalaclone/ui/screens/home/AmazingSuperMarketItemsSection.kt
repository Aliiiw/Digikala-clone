package com.alirahimi.digikalaclone.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.data.model.home.AmazingItem
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.ui.theme.*
import com.alirahimi.digikalaclone.util.DigitHelper
import com.alirahimi.digikalaclone.viewmodel.HomeViewModel

@Composable
fun AmazingSuperMarketItemsSection(viewModel: HomeViewModel = hiltViewModel()) {

    var loading by remember {
        mutableStateOf(false)
    }

    var amazingSuperMarketItemList by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }

    val amazingSuperMarketItemResult by viewModel.amazingSuperMarketItemsFlow.collectAsState()

    when (amazingSuperMarketItemResult) {

        is NetworkResult.Success -> {
            amazingSuperMarketItemList = amazingSuperMarketItemResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e(
                "2323",
                "Amazing Super Market Items error: ${amazingSuperMarketItemResult.message}"
            )

        }

        is NetworkResult.Loading -> {
            loading = true

        }
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.digikalaLightRed)
            .fillMaxWidth()
    ) {
        LazyRow(modifier = Modifier.background(MaterialTheme.colors.digikalaLightGreen)) {
            item {
                AmazingOfferCard(topImageId = R.drawable.supermarketamazings, bottomImageId = R.drawable.fresh)
            }

            items(amazingSuperMarketItemList) { item ->
                AmazingItem(item = item)
            }

            item {
                AmazingShowMoreItems()
            }
        }
    }
}