package com.alirahimi.digikalaclone.di

import android.content.Context
import com.alirahimi.digikalaclone.data.datastore.DataStoreRepository
import com.alirahimi.digikalaclone.data.datastore.DataStoreRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Singleton
    @Provides
    fun provideDataStoreRepository(@ApplicationContext context: Context): DataStoreRepository =
        DataStoreRepositoryImpl(context = context)


}
