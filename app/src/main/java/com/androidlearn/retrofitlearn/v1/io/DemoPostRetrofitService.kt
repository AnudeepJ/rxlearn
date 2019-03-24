package com.androidlearn.retrofitlearn.v1.io

import com.androidlearn.retrofitlearn.v1.io.model.DemoPostItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DemoPostRetrofitService {

    //Api to show get request
    @GET("posts")
    fun fetchPostItemsList(): Call<List<DemoPostItem>>

    @POST("posts")
    fun postCommnet(@Body postItem: DemoPostItem) :Call<DemoPostItem>


}