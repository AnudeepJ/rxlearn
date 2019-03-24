package com.androidlearn.retrofitlearn.v0.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidlearn.retrofitlearn.R
import com.androidlearn.retrofitlearn.RetrofitServiceBuilderV1
import com.androidlearn.retrofitlearn.v0.io.RetrofitServiceBuilder
import com.androidlearn.retrofitlearn.v0.io.model.GithubRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_repositories_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val TAG = "RepositoriesFragment"
const val SORT_TYPE = "updated"

class RepositoriesFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_repositories_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        githubRV.layoutManager = LinearLayoutManager(context)


//        fetchGitHubRepos()
        fetchGitHubReposV1()

    }

    fun fetchGitHubRepos() {
        val reposForUser = RetrofitServiceBuilder.getService().reposForUserSortByUpdated(
            "yigit",
            SORT_TYPE
        )
        reposForUser.enqueue(object : Callback<List<GithubRepo>> {
            override fun onFailure(call: Call<List<GithubRepo>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<GithubRepo>>, response: Response<List<GithubRepo>>) {
                Log.d(TAG, "" + response.body()?.size)
                githubRV.adapter = RepositoriesAdapter(response.body()!!)

            }

        })
    }


    fun fetchGitHubReposV1() {
        val reposForUserSortByUpdated =
            RetrofitServiceBuilderV1.getService().reposForUserSortByUpdatedUsingRx(
                "yigit",
                com.androidlearn.retrofitlearn.v0.ui.SORT_TYPE
            )
        val disposable = reposForUserSortByUpdated
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                githubRV.adapter = RepositoriesAdapter(it!!)

            }, {
                it.printStackTrace()
            })
    }

    fun onFetchSucees(list: List<GithubRepo>) {

    }

    private fun onFetchFailed(throwable: Throwable) {
        throwable.message.let {
        }
    }

}