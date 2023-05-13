package com.alirahimi.digikalaclone.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.data.model.home.MainCategory
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.ui.theme.darkText
import com.alirahimi.digikalaclone.ui.theme.spacing
import com.alirahimi.digikalaclone.viewmodel.HomeViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeCategoryListSection(viewModel: HomeViewModel = hiltViewModel()) {

    var loading by remember {
        mutableStateOf(false)
    }

    var categoryList by remember {
        mutableStateOf<List<MainCategory>>(emptyList())
    }

    val categoryResult by viewModel.categoryItemsFlow.collectAsState()

    when (categoryResult) {

        is NetworkResult.Success -> {
            categoryList = categoryResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e(
                "2323",
                "Category Result error: ${categoryResult.message}"
            )

        }

        is NetworkResult.Loading -> {
            loading = true

        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.medium),
            text = stringResource(id = R.string.category_title),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText
        )

        FlowRow(
            horizontalArrangement = Arrangement.SpaceAround,
            maxItemsInEachRow = 3,
            modifier = Modifier.fillMaxWidth(

            )
        ) {
//            categoryList.forEach { item ->
//
//                HomeCategoryItem(item = item)
//            }
            for (item in categoryList) {
                HomeCategoryItem(item = item)
            }
        }
    }
}

@Composable
fun HomeCategoryItem(item: MainCategory) {
    Column(
        modifier = Modifier
            .size(100.dp, 160.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .size(100.dp)
                .padding(vertical = MaterialTheme.spacing.extraSmall),
            painter = rememberAsyncImagePainter(item.image), contentDescription = ""
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MaterialTheme.spacing.extraSmall),
            text = item.name,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}