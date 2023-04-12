package com.alirahimi.digikalaclone.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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

}