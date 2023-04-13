package com.alirahimi.digikalaclone.repository

import com.alirahimi.digikalaclone.data.db.BasketDao
import com.alirahimi.digikalaclone.data.model.basket.BasketItem
import com.alirahimi.digikalaclone.data.model.basket.CartStatus
import com.alirahimi.digikalaclone.data.model.home.StoreProduct
import com.alirahimi.digikalaclone.data.remote.BaseApiResponse
import com.alirahimi.digikalaclone.data.remote.BasketApiInterface
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import javax.inject.Inject

class BasketRepository @Inject constructor(
    private val api: BasketApiInterface,
    private val dao: BasketDao
) :
    BaseApiResponse() {

    val currentBasketItems = dao.getAllItems(status = CartStatus.CURRENT_CART)
    val nextBasketItems = dao.getAllItems(status = CartStatus.NEXT_CART)
    suspend fun getSuggestedItems(): NetworkResult<List<StoreProduct>> = safeApiCall {
        api.getSuggestedItems()
    }

    suspend fun insertBasketItem(cart: BasketItem) = dao.insertBasketItem(cart)

    suspend fun removeFromBasket(item: BasketItem) = dao.removeFromBasket(item)

    suspend fun changeItemStatus(id: String, newCartStatus: CartStatus) =
        dao.changeItemStatus(id, newCartStatus)

    suspend fun changeCountBasketItem(id: String, newCount: Int) =
        dao.changeCountBasketItem(id, newCount)
}