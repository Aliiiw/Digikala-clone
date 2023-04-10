package com.alirahimi.digikalaclone.ui.screens.category

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alirahimi.digikalaclone.data.model.category.*
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.ui.components.MyLoading
import com.alirahimi.digikalaclone.viewmodel.CategoryViewModel

@Composable
fun CategorySection(viewModel: CategoryViewModel = hiltViewModel()) {

    var loading by remember {
        mutableStateOf(false)
    }

    var toolList by remember {
        mutableStateOf<List<SubCategory>>(emptyList())
    }

    var digitalList by remember {
        mutableStateOf<List<SubCategory>>(emptyList())
    }

    var mobileList by remember {
        mutableStateOf<List<SubCategory>>(emptyList())
    }

    var supermarketList by remember {
        mutableStateOf<List<SubCategory>>(emptyList())
    }

    var fashionList by remember {
        mutableStateOf<List<SubCategory>>(emptyList())
    }

    var nativeList by remember {
        mutableStateOf<List<SubCategory>>(emptyList())
    }

    var toyList by remember {
        mutableStateOf<List<SubCategory>>(emptyList())
    }

    var beautyList by remember {
        mutableStateOf<List<SubCategory>>(emptyList())
    }

    var homeList by remember {
        mutableStateOf<List<SubCategory>>(emptyList())
    }

    var bookList by remember {
        mutableStateOf<List<SubCategory>>(emptyList())
    }

    var sportList by remember {
        mutableStateOf<List<SubCategory>>(emptyList())
    }

    val subCategoryResult by viewModel.categoryItemsFlow.collectAsState()
    when (subCategoryResult) {
        is NetworkResult.Success -> {

            subCategoryResult.data?.let {
                toolList = it.tool
                digitalList = it.digital
                mobileList = it.mobile
                supermarketList = it.supermarket
                fashionList = it.fashion
                nativeList = it.native
                toyList = it.toy
                beautyList = it.beauty
                homeList = it.home
                bookList = it.book
                sportList = it.sport
            }

            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("2323", "Sub Category Result error : ${subCategoryResult.message}")
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }

    if (loading) {
        val config = LocalConfiguration.current
        MyLoading(height = config.screenHeightDp.dp, isDark = true)
    } else {
        Column(modifier = Modifier.fillMaxSize()) {

            CategoryItem(
                title = stringResource(id = R.string.industrial_tools_and_equipment),
                subList = toolList
            )

            CategoryItem(
                title = stringResource(id = R.string.digital_goods),
                subList = digitalList
            )

            CategoryItem(
                title = stringResource(id = R.string.mobile),
                subList = mobileList
            )

            CategoryItem(
                title = stringResource(id = R.string.fashion_and_clothing),
                subList = fashionList
            )

            CategoryItem(
                title = stringResource(id = R.string.supermarket_product),
                subList = supermarketList
            )

            CategoryItem(
                title = stringResource(id = R.string.native_and_local_products),
                subList = nativeList
            )

            CategoryItem(
                title = stringResource(id = R.string.toys_children_and_babies),
                subList = toyList
            )

            CategoryItem(
                title = stringResource(id = R.string.beauty_and_health),
                subList = beautyList
            )

            CategoryItem(
                title = stringResource(id = R.string.home_and_kitchen),
                subList = homeList
            )

            CategoryItem(
                title = stringResource(id = R.string.books_and_stationery),
                subList = bookList
            )

            CategoryItem(
                title = stringResource(id = R.string.sports_and_travel),
                subList = sportList
            )
        }
    }
}