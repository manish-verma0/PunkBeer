package com.manish.punkbeer.data.repository

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val retrofitService: RetrofitService) {
    suspend fun getBeerList() =
        retrofitService.getBeerList()
}