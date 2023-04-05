package com.alirahimi.digikalaclone.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alirahimi.digikalaclone.viewmodel.HomeViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController) {
    Home(navController = navController)
}

@Composable
fun Home(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {

    LaunchedEffect(true) {
        refreshDataFromServer(viewModel = viewModel)
    }

    SwipeRefreshSection(navController = navController, viewModel = viewModel)
}

@Composable
fun SwipeRefreshSection(navController: NavHostController, viewModel: HomeViewModel) {
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
        LazyColumn(modifier = Modifier.fillMaxSize()) {

            item { SearchBarSection() }
            item { TopSliderSection() }
            item { ShowCaseSection(navController = navController) }

        }
    }
}

private suspend fun refreshDataFromServer(viewModel: HomeViewModel) {
    viewModel.getSlider()
}