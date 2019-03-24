package com.androidlearn.retrofitlearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.androidlearn.retrofitlearn.v0.ui.RepositoriesFragment
import com.androidlearn.retrofitlearn.v1.ui.DemoPostsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.fragmentContainer, RepositoriesFragment())
        beginTransaction.commit()
    }
}
