package com.alirahimi.digikalaclone.data.remote

import com.alirahimi.digikalaclone.data.model.ResponseResult
import com.alirahimi.digikalaclone.data.model.home.StoreProduct
import retrofit2.Response
import retrofit2.http.GET


interface ProfileApiInterface {
    @GET("v1/getAllProducts")
    suspend fun getSuggestedItems(): Response<ResponseResult<List<StoreProduct>>>

}