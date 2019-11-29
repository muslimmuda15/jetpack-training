package com.app.rachmad.movie

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.app.rachmad.movie.viewmodel.ListModel

open class BaseActivity: AppCompatActivity() {
    val viewModel by lazy {
        ViewModelProviders.of(this).get(ListModel::class.java)
    }
}