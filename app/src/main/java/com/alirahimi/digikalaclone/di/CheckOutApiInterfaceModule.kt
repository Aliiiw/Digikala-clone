package com.alirahimi.digikalaclone.di

import com.alirahimi.digikalaclone.data.remote.CheckOutApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CheckOutApiInterfaceModule {

    @Singleton
    @Provides
    fun provideCheckOutApiService(retrofit: Retrofit): CheckOutApiInterface =
        retrofit.create(CheckOutApiInterface::class.java)

}
