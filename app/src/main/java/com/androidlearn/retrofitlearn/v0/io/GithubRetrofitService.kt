package com.androidlearn.retrofitlearn.v0.io

import com.androidlearn.retrofitlearn.v0.io.model.GithubRepo
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubRetrofitService {

    //Api to show path in url
    @GET("users/{user}/repos")
    fun reposForUser(@Path("user") author: String): Call<List<GithubRepo>>


    //Api to show queryu param in url
    @GET("users/{user}/repos")
    fun reposForUserSortByUpdated(@Path("user") author: String, @Query("sort") sortBy: String): Call<List<GithubRepo>>


    //Api to show rxjava converter
    @GET("users/{user}/repos")
    fun reposForUserSortByUpdatedUsingRx(@Path("user") author: String, @Query("sort") sortBy: String): Single<List<GithubRepo>>


}