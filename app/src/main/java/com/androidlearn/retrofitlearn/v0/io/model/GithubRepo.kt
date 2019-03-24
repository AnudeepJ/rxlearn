package com.androidlearn.retrofitlearn.v0.io.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GithubRepo(
    @Expose
    @SerializedName("id")
    var id: Int,
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("full_name")
    val fullName: String,
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("url")
    val url: String
)
