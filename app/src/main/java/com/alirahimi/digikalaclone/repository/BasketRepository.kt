package com.alirahimi.digikalaclone.repository

import com.alirahimi.digikalaclone.data.model.home.StoreProduct
import com.alirahimi.digikalaclone.data.remote.BaseApiResponse
import com.alirahimi.digikalaclone.data.remote.BasketApiInterface
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import javax.inject.Inject

class BasketRepository @Inject constructor(private val api: BasketApiInterface) :
    BaseApiResponse() {

    suspend fun getSuggestedItems(): NetworkResult<List<StoreProduct>> = safeApiCall {
        api.getSuggestedItems()
    }
}