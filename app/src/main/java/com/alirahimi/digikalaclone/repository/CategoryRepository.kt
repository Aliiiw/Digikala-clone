package com.alirahimi.digikalaclone.repository

import com.alirahimi.digikalaclone.data.model.category.CategoryResponse
import com.alirahimi.digikalaclone.data.remote.BaseApiResponse
import com.alirahimi.digikalaclone.data.remote.CategoryApiInterface
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val api: CategoryApiInterface) :
    BaseApiResponse() {

    suspend fun getSubCategories(): NetworkResult<CategoryResponse> = safeApiCall {
        api.getSubCategories()
    }

}