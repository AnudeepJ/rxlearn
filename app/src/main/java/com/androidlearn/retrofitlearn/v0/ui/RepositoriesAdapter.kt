package com.androidlearn.retrofitlearn.v0.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.androidlearn.retrofitlearn.R
import com.androidlearn.retrofitlearn.v0.io.model.GithubRepo

class RepositoriesAdapter(private val repoList: List<GithubRepo>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(container: ViewGroup, itemType: Int): RecyclerView.ViewHolder {
        return RepositoriesViewHolder(
            LayoutInflater.from(container.context).inflate(
                R.layout.repositories_list_item_layout,
                container,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val repoViewHolder = viewHolder as RepositoriesViewHolder
        repoViewHolder.repoNameTv.text = repoList[position].name


    }


    inner class RepositoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val repoNameTv = itemView.findViewById(R.id.repoNameTv) as TextView


    }

}