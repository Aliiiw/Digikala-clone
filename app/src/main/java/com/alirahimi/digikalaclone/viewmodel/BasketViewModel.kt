package com.alirahimi.digikalaclone.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alirahimi.digikalaclone.data.model.category.CategoryResponse
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.repository.BasketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(private val repository: BasketRepository) :
    ViewModel() {

    val categoryItemsFlow =
        MutableStateFlow<NetworkResult<CategoryResponse>>(NetworkResult.Loading())

    suspend fun getAllDataFromServer() {
        viewModelScope.launch {

        }
    }
}