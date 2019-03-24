package com.androidlearn.retrofitlearn.v1.io

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DemoPostServiceBuilder {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    private var builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    private var retrofitService = builder.build()
        .create(DemoPostRetrofitService::class.java)

    fun getService(): DemoPostRetrofitService {
        return retrofitService
    }


}