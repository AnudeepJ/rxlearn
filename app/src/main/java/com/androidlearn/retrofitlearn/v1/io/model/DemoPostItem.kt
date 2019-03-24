package com.androidlearn.retrofitlearn.v1.io.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DemoPostItem(
    @Expose
    @SerializedName("userId")
    var userId: Int,
    @Expose(serialize = false)
    @SerializedName("id")
    var id: Int,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("body")
    val body: String
)