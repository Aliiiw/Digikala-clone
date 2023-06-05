package com.alirahimi.digikalaclone.repository

import com.alirahimi.digikalaclone.data.db.BasketDao
import com.alirahimi.digikalaclone.data.model.basket.BasketItem
import com.alirahimi.digikalaclone.data.model.basket.CartStatus
import com.alirahimi.digikalaclone.data.model.home.StoreProduct
import com.alirahimi.digikalaclone.data.remote.BaseApiResponse
import com.alirahimi.digikalaclone.data.remote.BasketApiInterface
import com.alirahimi.digikalaclone.data.remote.CheckOutApiInterface
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import javax.inject.Inject

class CheckOutRepository @Inject constructor(
    private val api: CheckOutApiInterface,

    ) :
    BaseApiResponse() {
}