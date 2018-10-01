package com.example.keshl.mymotivation.presentation.common

interface BasePresenter<V> {
    fun onCreateView(v: V)
    fun onDestroy()
}