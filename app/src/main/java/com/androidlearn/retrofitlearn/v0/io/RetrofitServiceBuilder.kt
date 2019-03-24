package com.androidlearn.retrofitlearn.v0.io

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceBuilder {
    private const val BASE_URL = "https://api.github.com/"

    private var builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    private var retrofitService = builder.build()
        .create(GithubRetrofitService::class.java)

    fun getService(): GithubRetrofitService {
        return retrofitService
    }


}