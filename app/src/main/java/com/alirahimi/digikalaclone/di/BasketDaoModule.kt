package com.alirahimi.digikalaclone.di

import com.alirahimi.digikalaclone.data.db.BasketDao
import com.alirahimi.digikalaclone.data.db.DigikalaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BasketDaoModule {

    @Provides
    @Singleton
    fun provideBasketDao(database: DigikalaDatabase): BasketDao = database.basketDao()

}