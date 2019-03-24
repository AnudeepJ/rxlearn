package com.androidlearn.retrofitlearn.v1.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.androidlearn.retrofitlearn.R
import com.androidlearn.retrofitlearn.RetrofitServiceBuilderV1
import com.androidlearn.retrofitlearn.v1.io.DemoPostServiceBuilder
import com.androidlearn.retrofitlearn.v1.io.model.DemoPostItem
import kotlinx.android.synthetic.main.fragment_repositories_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val TAG = "RepositoriesFragment"
const val SORT_TYPE = "updated"

class DemoPostsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_repositories_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        githubRV.layoutManager = LinearLayoutManager(context)

        val postListCall = DemoPostServiceBuilder.getService().fetchPostItemsList()


        fetchPosts(postListCall)

        createPost()


    }

    private fun createPost() {
        val demoPostItem = DemoPostItem(100, -99, "New Post", "New Text")
        val createPostCall = DemoPostServiceBuilder.getService().postCommnet(demoPostItem)
        createPostCall.enqueue(object : Callback<DemoPostItem> {
            override fun onFailure(call: Call<DemoPostItem>, t: Throwable) {

            }

            override fun onResponse(call: Call<DemoPostItem>, response: Response<DemoPostItem>) {
                Toast.makeText(context, response.body().toString(), Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun fetchPosts(postListCall: Call<List<DemoPostItem>>) {
        postListCall.enqueue(object : Callback<List<DemoPostItem>> {
            override fun onFailure(call: Call<List<DemoPostItem>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<DemoPostItem>>, response: Response<List<DemoPostItem>>) {
                Log.d(TAG, "" + response.body()?.size)
                githubRV.adapter = DemoPostsAdapter(response.body()!!)

            }

        })
    }




}