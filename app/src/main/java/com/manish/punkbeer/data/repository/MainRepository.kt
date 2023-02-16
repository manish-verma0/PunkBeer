package com.manish.punkbeer.data.repository

import androidx.room.withTransaction
import com.manish.punkbeer.core.utils.networkBoundResource
import com.manish.punkbeer.data.room.AppDatabase
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.delay
import javax.inject.Inject


@ActivityRetainedScoped
class MainRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val db: AppDatabase
) {

    private val beerDao = db.beerDao()

    fun getBeerList() = networkBoundResource(
        query = {
            beerDao.getAllBeers()
        },
        fetch = {
            delay(2000)
            remoteDataSource.getBeerList()
        },
        saveFetchResult = { beers ->
            db.withTransaction {
                beerDao.deleteAllBeers()
                beers.body()?.let { beerDao.insertBeers(beers = it) }
            }
        }
    )
}