package com.alirahimi.digikalaclone.repository

import com.alirahimi.digikalaclone.data.remote.AddressApiInterface
import com.alirahimi.digikalaclone.data.remote.BaseApiResponse
import javax.inject.Inject

class AddressRepository @Inject constructor(
    private val api: AddressApiInterface,

    ) :
    BaseApiResponse() {
}