package com.alirahimi.digikalaclone.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alirahimi.digikalaclone.data.model.basket.BasketItem

@Database(entities = [BasketItem::class], version = 1, exportSchema = false)
abstract class DigikalaDatabase : RoomDatabase() {

    abstract fun basketDao(): BasketDao

}