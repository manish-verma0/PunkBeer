package com.manish.punkbeer.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manish.punkbeer.data.model.Beer
import kotlinx.coroutines.flow.Flow

@Dao
interface BeerDao {

    @Query("SELECT * FROM beers")
    fun getAllBeers(): Flow<List<Beer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBeers(beers: List<Beer>)

    @Query("DELETE FROM beers")
    suspend fun deleteAllBeers()
}