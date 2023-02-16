package com.manish.punkbeer.core.di.modules

import android.app.Application
import androidx.room.Room
import com.manish.punkbeer.data.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "app_database")
            .build()
}