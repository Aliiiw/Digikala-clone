package com.alirahimi.digikalaclone.ui.screens.category

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alirahimi.digikalaclone.data.model.category.CategoryResponse
import com.alirahimi.digikalaclone.data.model.home.AmazingItem
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.ui.screens.home.*
import com.alirahimi.digikalaclone.viewmodel.CategoryViewModel
import com.alirahimi.digikalaclone.viewmodel.HomeViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch

@Composable
fun CategoryScreen(navController: NavHostController) {
    Category(navController = navController)
}

@Composable
fun Category(
    viewModel: CategoryViewModel = hiltViewModel(),
    navController: NavHostController
) {
    SwipeRefreshSection(navController = navController, viewModel = viewModel)
}

@Composable
private fun SwipeRefreshSection(navController: NavHostController, viewModel: CategoryViewModel) {
    val refreshScope = rememberCoroutineScope()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)

    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = {
            refreshScope.launch {
                refreshDataFromServer(viewModel = viewModel)
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp)
        ) {
            item { SearchBarSection() }
            item { CategorySection() }

        }
    }
}

private suspend fun refreshDataFromServer(viewModel: CategoryViewModel) {
    viewModel.getAllDataFromServer()
}