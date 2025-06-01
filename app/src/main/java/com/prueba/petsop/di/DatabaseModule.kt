package com.prueba.petsop.di

import android.content.Context
import androidx.room.Room
import com.prueba.petsop.data.AppDatabase
import com.prueba.petsop.data.FavoriteDao
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
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "petshop-db"
        ).build()
    }

    @Provides
    fun provideFavoriteDao(db: AppDatabase): FavoriteDao {
        return db.favoriteDao()
    }
}