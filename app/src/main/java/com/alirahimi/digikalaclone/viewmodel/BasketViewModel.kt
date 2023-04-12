package com.alirahimi.digikalaclone.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alirahimi.digikalaclone.data.model.basket.BasketItem
import com.alirahimi.digikalaclone.data.model.basket.CartStatus
import com.alirahimi.digikalaclone.data.model.category.CategoryResponse
import com.alirahimi.digikalaclone.data.model.home.StoreProduct
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.repository.BasketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(private val repository: BasketRepository) :
    ViewModel() {

    val suggestedItemsFlow =
        MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())
    val currentBasketItemsFlow: Flow<List<BasketItem>> = repository.currentBasketItems

    suspend fun getAllDataFromServer() {
        viewModelScope.launch {
            suggestedItemsFlow.emit(
                repository.getSuggestedItems()
            )
        }
    }

    fun insertBasketItem(item: BasketItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertBasketItem(item)
        }
    }

    fun removeFromBasket(item: BasketItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeFromBasket(item)
        }
    }

    fun changeBasketItemCount(id: String, newCount: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.changeCountBasketItem(id, newCount)
        }
    }

    fun changeBasketItemStatus(id: String, newStatus: CartStatus) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.changeItemStatus(id, newStatus)
        }
    }
}