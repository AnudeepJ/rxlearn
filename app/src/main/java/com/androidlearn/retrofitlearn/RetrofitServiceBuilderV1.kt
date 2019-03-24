package com.androidlearn.retrofitlearn

import com.androidlearn.retrofitlearn.v0.io.GithubRetrofitService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitServiceBuilderV1 {
    private const val BASE_URL = "https://api.github.com/"
    private const val CONNECT_TIMEOUT_SECONDS = 60L
    private const val READ_TIMEOUT_SECONDS = 60L

    private val httpInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)


    private val okHttpClientBuilder = OkHttpClient.Builder()
        .connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .addInterceptor(httpInterceptor)
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .build()
            chain.proceed(request)
        }
    private var builder = Retrofit.Builder().baseUrl(BASE_URL)
        .client(okHttpClientBuilder.build())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())


    private var retrofitService = builder.build()
        .create(GithubRetrofitService::class.java)

    fun getService(): GithubRetrofitService {
        return retrofitService
    }


}