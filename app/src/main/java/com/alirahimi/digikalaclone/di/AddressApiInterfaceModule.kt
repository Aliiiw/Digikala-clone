package com.alirahimi.digikalaclone.di

import com.alirahimi.digikalaclone.data.remote.AddressApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AddressApiInterfaceModule {

    @Singleton
    @Provides
    fun provideAddressApiService(retrofit: Retrofit): AddressApiInterface =
        retrofit.create(AddressApiInterface::class.java)

}
