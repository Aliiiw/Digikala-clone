package com.alirahimi.digikalaclone.ui.screens.category

import android.util.Log
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alirahimi.digikalaclone.data.model.home.AmazingItem
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.viewmodel.CategoryViewModel

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = hiltViewModel(),
    navController: NavHostController
) {
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
}