package com.alirahimi.digikalaclone.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alirahimi.digikalaclone.data.model.basket.BasketDetail
import com.alirahimi.digikalaclone.data.model.basket.BasketItem
import com.alirahimi.digikalaclone.data.model.basket.CartStatus
import com.alirahimi.digikalaclone.data.model.home.StoreProduct
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.repository.BasketRepository
import com.alirahimi.digikalaclone.ui.screens.basket.BasketScreenState
import com.alirahimi.digikalaclone.util.DigitHelper.applyDiscount
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(private val repository: BasketRepository) :
    ViewModel() {

    val suggestedItemsFlow =
        MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())

    private val _currentBasketItemsFlow: MutableStateFlow<BasketScreenState<List<BasketItem>>> =
        MutableStateFlow(BasketScreenState.Loading)
    val currentBasketItems: StateFlow<BasketScreenState<List<BasketItem>>> = _currentBasketItemsFlow

    private val _nextBasketItemsFlow: MutableStateFlow<BasketScreenState<List<BasketItem>>> =
        MutableStateFlow(BasketScreenState.Loading)
    val nextBasketItemsFlow: StateFlow<BasketScreenState<List<BasketItem>>> = _nextBasketItemsFlow

    val currentBasketItemsCount = repository.currentBasketItemsCount
    val nextBasketItemsCount = repository.nextBasketItemsCount

    val basketDetail =
        MutableStateFlow(BasketDetail(0, 0, 0, 0))

    init {
        viewModelScope.launch(Dispatchers.IO) {
            launch {
                repository.currentBasketItems.collectLatest { basketItem ->
                    _currentBasketItemsFlow.emit(BasketScreenState.Success(basketItem))
                }
            }

            launch {
                repository.currentBasketItems.collectLatest { basketItem ->
                    calculateCartDetails(basketItem)
                }
            }

            launch {
                repository.nextBasketItems.collectLatest { nextBasketItem ->
                    _nextBasketItemsFlow.emit(BasketScreenState.Success(nextBasketItem))
                }
            }
        }
    }

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

    private fun calculateCartDetails(items: List<BasketItem>) {
        var totalCount = 0
        var totalPrice = 0L
        var totalDiscount = 0L
        var payablePrice = 0L
        items.forEach { item ->
            totalPrice += item.price * item.count
            payablePrice += applyDiscount(item.price, item.discountPercent) * item.count
            totalCount += item.count
        }
        totalDiscount = totalPrice - payablePrice
        basketDetail.value = BasketDetail(totalCount, totalPrice, totalDiscount, payablePrice)
    }

}