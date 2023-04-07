package com.alirahimi.digikalaclone.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.alirahimi.digikalaclone.data.model.home.ProposalBanner
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.ui.theme.roundedShape
import com.alirahimi.digikalaclone.ui.theme.spacing
import com.alirahimi.digikalaclone.viewmodel.HomeViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProposalCardSection(viewModel: HomeViewModel = hiltViewModel()) {

    var loading by remember {
        mutableStateOf(false)
    }

    var proposalBannerList by remember {
        mutableStateOf<List<ProposalBanner>>(emptyList())
    }

    val proposalBannerResult by viewModel.proposalBannerItemsFlow.collectAsState()

    when (proposalBannerResult) {

        is NetworkResult.Success -> {
            proposalBannerList = proposalBannerResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e(
                "2323",
                "Proposal Banner Result error: ${proposalBannerResult.message}"
            )

        }

        is NetworkResult.Loading -> {
            loading = true

        }
    }

    //Lazy vertical Grid we can use this too
    FlowRow(
        maxItemsInEachRow = 2,
        modifier = Modifier
            .fillMaxWidth()
            .height(290.dp)
            .padding(MaterialTheme.spacing.small)
    ) {
        proposalBannerList.forEach { item ->
            ProposalCardItem(banner = item)
        }
    }
}

@Composable
fun ProposalCardItem(banner: ProposalBanner) {

    Card(
        shape = MaterialTheme.roundedShape.semiMedium,
        modifier = Modifier
            .height(140.dp)
            .fillMaxWidth(0.5f)
            .padding(
                horizontal = MaterialTheme.spacing.small,
                vertical = MaterialTheme.spacing.small
            )
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberAsyncImagePainter(model = banner.image),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
    }
}