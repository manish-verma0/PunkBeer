package com.manish.punkbeer.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.manish.punkbeer.data.model.Beer

@Database(entities = [Beer::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun beerDao(): BeerDao
}