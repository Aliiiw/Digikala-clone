package com.alirahimi.digikalaclone.data.remote

import com.alirahimi.digikalaclone.data.model.ResponseResult
import com.alirahimi.digikalaclone.data.model.profile.LoginRequest
import com.alirahimi.digikalaclone.data.model.profile.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
interface ProfileApiInterface {
    @POST("v1/login")
    suspend fun login(@Body login: LoginRequest): Response<ResponseResult<LoginResponse>>

}