package com.manish.punkbeer.data.repository

import com.manish.punkbeer.core.utils.Constants.GET_BEERS
import com.manish.punkbeer.data.model.Beer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface RetrofitService {

    @GET(GET_BEERS)
    suspend fun getBeerList() : Response<List<Beer>>
}