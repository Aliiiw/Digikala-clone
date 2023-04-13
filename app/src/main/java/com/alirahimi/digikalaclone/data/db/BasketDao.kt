package com.alirahimi.digikalaclone.data.db

import androidx.room.*
import com.alirahimi.digikalaclone.data.model.basket.BasketItem
import com.alirahimi.digikalaclone.data.model.basket.CartStatus
import com.alirahimi.digikalaclone.util.Constants.SHOPPING_CART_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface BasketDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBasketItem(cart: BasketItem)

    @Query("SELECT * FROM $SHOPPING_CART_TABLE WHERE cartStatus=:status")
    fun getAllItems(status: CartStatus): Flow<List<BasketItem>>

    @Delete
    suspend fun removeFromBasket(item: BasketItem)

    @Query("UPDATE $SHOPPING_CART_TABLE SET cartStatus=:newCartStatus WHERE itemId=:id")
    suspend fun changeItemStatus(id: String, newCartStatus: CartStatus)

    @Query("UPDATE $SHOPPING_CART_TABLE SET count=:newCount WHERE itemId=:id")
    suspend fun changeCountBasketItem(id: String, newCount: Int)

    @Query("select total(count) as count from $SHOPPING_CART_TABLE where cartStatus=:status")
    fun getBasketItemsCount(status: CartStatus): Flow<Int>

}