package com.alirahimi.digikalaclone.di

import android.content.Context
import androidx.room.Room
import com.alirahimi.digikalaclone.data.db.DigikalaDatabase
import com.alirahimi.digikalaclone.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        DigikalaDatabase::class.java,
        DATABASE_NAME
    ).build()
}
