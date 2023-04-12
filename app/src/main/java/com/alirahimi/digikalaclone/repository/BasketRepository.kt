package com.alirahimi.digikalaclone.repository

import com.alirahimi.digikalaclone.data.remote.BaseApiResponse
import com.alirahimi.digikalaclone.data.remote.BasketApiInterface
import javax.inject.Inject

class BasketRepository @Inject constructor(private val api: BasketApiInterface) :
    BaseApiResponse() {

}