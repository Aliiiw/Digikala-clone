package com.alirahimi.digikalaclone.repository

import com.alirahimi.digikalaclone.data.model.home.*
import com.alirahimi.digikalaclone.data.remote.BaseApiResponse
import com.alirahimi.digikalaclone.data.remote.HomeApiInterface
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.data.remote.ProfileApiInterface
import javax.inject.Inject

class ProfileRepository @Inject constructor(private val api: ProfileApiInterface) : BaseApiResponse() {

}