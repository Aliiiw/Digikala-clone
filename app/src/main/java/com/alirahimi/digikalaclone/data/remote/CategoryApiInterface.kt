package com.alirahimi.digikalaclone.data.remote

import com.alirahimi.digikalaclone.data.model.ResponseResult
import com.alirahimi.digikalaclone.data.model.category.CategoryResponse
import com.alirahimi.digikalaclone.data.model.home.*
import retrofit2.Response
import retrofit2.http.GET

interface CategoryApiInterface {

    @GET("v1/getSubCategories")
    suspend fun getSubCategories(): Response<ResponseResult<CategoryResponse>>

}