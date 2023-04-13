package com.alirahimi.digikalaclone.repository

import com.alirahimi.digikalaclone.data.model.profile.LoginRequest
import com.alirahimi.digikalaclone.data.model.profile.LoginResponse
import com.alirahimi.digikalaclone.data.remote.BaseApiResponse
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.data.remote.ProfileApiInterface
import javax.inject.Inject

class ProfileRepository @Inject constructor(private val api: ProfileApiInterface) :
    BaseApiResponse() {
    suspend fun login(loginRequest: LoginRequest): NetworkResult<LoginResponse> = safeApiCall {
        api.login(loginRequest)
    }

}