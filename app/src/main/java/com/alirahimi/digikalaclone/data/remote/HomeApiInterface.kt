package com.alirahimi.digikalaclone.data.remote

import com.alirahimi.digikalaclone.data.model.ResponseResult
import com.alirahimi.digikalaclone.data.model.home.*
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiInterface {
    @GET("v1/getSlider")
    suspend fun getSlider(): Response<ResponseResult<List<Slider>>>

    @GET("v1/getAmazingProducts")
    suspend fun getAmazingItems(): Response<ResponseResult<List<AmazingItem>>>

    @GET("v1/getSuperMarketAmazingProducts")
    suspend fun getAmazingSuperMarketItems(): Response<ResponseResult<List<AmazingItem>>>

    @GET("v1/get4Banners")
    suspend fun getProposalBanners(): Response<ResponseResult<List<ProposalBanner>>>

    @GET("v1/getCategories")
    suspend fun getCategories(): Response<ResponseResult<List<MainCategory>>>

    @GET("v1/getCenterBanners")
    suspend fun getCenterBanners(): Response<ResponseResult<List<Slider>>>

    @GET("v1/getBestsellerProducts")
    suspend fun getBestsellerProducts(): Response<ResponseResult<List<StoreProduct>>>

}