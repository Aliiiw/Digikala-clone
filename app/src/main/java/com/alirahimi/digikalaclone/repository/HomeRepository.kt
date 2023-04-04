package com.alirahimi.digikalaclone.repository

import com.alirahimi.digikalaclone.data.model.home.Slider
import com.alirahimi.digikalaclone.data.remote.BaseApiResponse
import com.alirahimi.digikalaclone.data.remote.HomeApiInterface
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: HomeApiInterface) : BaseApiResponse() {
    suspend fun getSlider(): NetworkResult<List<Slider>> = safeApiCall {
        api.getSlider()
    }
}