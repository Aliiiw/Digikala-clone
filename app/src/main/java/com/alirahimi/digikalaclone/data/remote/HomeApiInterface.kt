package com.alirahimi.digikalaclone.data.remote

import com.alirahimi.digikalaclone.data.model.ResponseResult
import com.alirahimi.digikalaclone.data.model.home.Slider
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiInterface {
    @GET("v1/getSlider")
    suspend fun getSlider(): Response<ResponseResult<List<Slider>>>
}