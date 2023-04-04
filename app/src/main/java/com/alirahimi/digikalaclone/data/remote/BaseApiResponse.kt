package com.alirahimi.digikalaclone.data.remote

import com.alirahimi.digikalaclone.data.model.ResponseResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

abstract class BaseApiResponse {

    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<ResponseResult<T>>): NetworkResult<T> =
        withContext(Dispatchers.IO) {
            try {
                val response = apiCall()
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        return@withContext NetworkResult.Success(message = body.message, body.data)
                    }
                }
                return@withContext getErrors(errorMessage = "code: ${response.code()}, message: ${response.message()}")
            } catch (e: Exception) {
                return@withContext getErrors(errorMessage = e.message ?: e.toString())
            }
        }


    private fun <T> getErrors(errorMessage: String): NetworkResult<T> =
        NetworkResult.Error(message = "Api call failed: $errorMessage")

}