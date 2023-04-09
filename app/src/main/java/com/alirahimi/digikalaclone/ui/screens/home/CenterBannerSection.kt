package com.alirahimi.digikalaclone.ui.screens.home

import android.util.Log
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.alirahimi.digikalaclone.data.model.home.Slider
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.ui.components.CenterBannerItem
import com.alirahimi.digikalaclone.viewmodel.HomeViewModel

@Composable
fun CenterBannerSection(bannerNumber: Int, viewModel: HomeViewModel = hiltViewModel()) {

    var loading by remember {
        mutableStateOf(false)
    }

    var centerBannerList by remember {
        mutableStateOf<List<Slider>>(emptyList())
    }

    val centerBannerResult by viewModel.centerBannerItemsFlow.collectAsState()

    when (centerBannerResult) {

        is NetworkResult.Success -> {
            centerBannerList = centerBannerResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e(
                "2323",
                "Center Banner List error: ${centerBannerResult.message}"
            )

        }

        is NetworkResult.Loading -> {
            loading = true

        }
    }

    if (centerBannerList.isNotEmpty()) {
        CenterBannerItem(imageUrl = centerBannerList[bannerNumber - 1].image)
    }
}