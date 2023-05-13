package com.alirahimi.digikalaclone.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alirahimi.digikalaclone.util.Constants
import com.alirahimi.digikalaclone.util.LocaleUtils
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

    val context = LocalContext.current
    LocaleUtils.setLocale(context = context, language = Constants.USER_LANGUAGE)

    LaunchedEffect(true) {
        refreshDataFromServer(viewModel = viewModel)
    }

    SwipeRefreshSection(navController = navController, viewModel = viewModel)
}

@Composable
private fun SwipeRefreshSection(navController: NavHostController, viewModel: HomeViewModel) {
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
//        LazyColumn(modifier = Modifier
//            .fillMaxSize()
//            .padding(bottom = 60.dp)) {
//
//            item { SearchBarSection() }
//            item { TopSliderSection() }
//            item { ShowCaseSection(navController = navController) }
//            item { AmazingItemsSection() }
//            item { ProposalCardSection() }
//            item { AmazingSuperMarketItemsSection() }
//            item { HomeCategoryListSection() }
//            item { CenterBannerSection(bannerNumber = 1) }
//            item { BestSellerOfferSection() }
//            item { CenterBannerSection(bannerNumber = 2) }
//            item { MostFavoriteProductsSection() }
//            item { CenterBannerSection(bannerNumber = 3) }
//            item { MostVisitedOfferSection() }
//            item { CenterBannerSection(bannerNumber = 4) }
//            item { CenterBannerSection(bannerNumber = 5) }
//            item { MostDiscountedProductsSection() }
//
//        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp)
        ) {
            items(
                count = 1,
                itemContent = {
                    SearchBarSection()
                }
            )

            items(
                count = 1,
                itemContent = {
                    TopSliderSection()
                }
            )
            items(
                count = 1,
                itemContent = {
                    ShowCaseSection(navController = navController)
                }
            )
            items(
                count = 1,
                itemContent = {
                    AmazingItemsSection()
                }
            )

            items(
                count = 1,
                itemContent = {
                    ProposalCardSection()
                }
            )

            items(
                count = 1,
                itemContent = {
                    AmazingSuperMarketItemsSection()
                }
            )

            items(
                count = 1,
                itemContent = {
                    HomeCategoryListSection()
                }
            )

            items(
                count = 1,
                itemContent = {
                    CenterBannerSection(bannerNumber = 1)
                }
            )
            items(
                count = 1,
                itemContent = {
                    BestSellerOfferSection()
                }
            )

            items(
                count = 1,
                itemContent = {
                    CenterBannerSection(bannerNumber = 2)
                }
            )
            items(
                count = 1,
                itemContent = {
                    MostFavoriteProductsSection()
                }
            )

            items(
                count = 1,
                itemContent = {
                    CenterBannerSection(bannerNumber = 3)
                }
            )
            items(
                count = 1,
                itemContent = {
                    MostVisitedOfferSection()
                }
            )

            items(
                count = 1,
                itemContent = {
                    CenterBannerSection(bannerNumber = 4)
                }
            )

            items(
                count = 1,
                itemContent = {
                    CenterBannerSection(bannerNumber = 5)
                }
            )
            items(
                count = 1,
                itemContent = {
                    MostDiscountedProductsSection()
                }
            )


//            item(key = "myKey1") { SearchBarSection() }
//            item(key = "myKey2") { TopSliderSection() }
//            item(key = "myKey3") { ShowCaseSection(navController = navController) }
//            item(key = "myKey4") { AmazingItemsSection() }
//            item(key = "myKey5") { ProposalCardSection() }
//            item(key = "myKey6") { AmazingSuperMarketItemsSection() }
//            item(key = "myKey7") { HomeCategoryListSection() }
//            item(key = "myKey8") { CenterBannerSection(bannerNumber = 1) }
//            item(key = "myKey9") { BestSellerOfferSection() }
//            item(key = "myKey10") { CenterBannerSection(bannerNumber = 2) }
//            item(key = "myKey11") { MostFavoriteProductsSection() }
//            item(key = "myKey12") { CenterBannerSection(bannerNumber = 3) }
//            item(key = "myKey13") { MostVisitedOfferSection() }
//            item(key = "myKey14") { CenterBannerSection(bannerNumber = 4) }
//            item(key = "myKey15") { CenterBannerSection(bannerNumber = 5) }
//            item(key = "myKey16") { MostDiscountedProductsSection() }

        }
    }
}

private suspend fun refreshDataFromServer(viewModel: HomeViewModel) {
    viewModel.getAllDataFromServer()
}