package com.alirahimi.digikalaclone.repository

import com.alirahimi.digikalaclone.data.model.home.AmazingItem
import com.alirahimi.digikalaclone.data.model.home.ProposalBanner
import com.alirahimi.digikalaclone.data.model.home.Slider
import com.alirahimi.digikalaclone.data.remote.BaseApiResponse
import com.alirahimi.digikalaclone.data.remote.HomeApiInterface
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: HomeApiInterface) : BaseApiResponse() {
    suspend fun getSlider(): NetworkResult<List<Slider>> = safeApiCall {
        api.getSlider()
    }

    suspend fun getAmazingItems(): NetworkResult<List<AmazingItem>> = safeApiCall {
        api.getAmazingItems()
    }

    suspend fun getAmazingSuperMarketItems(): NetworkResult<List<AmazingItem>> = safeApiCall {
        api.getAmazingSuperMarketItems()
    }

    suspend fun getProposalBanners(): NetworkResult<List<ProposalBanner>> = safeApiCall {
        api.getProposalBanners()
    }


}