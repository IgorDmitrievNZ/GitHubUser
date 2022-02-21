package com.example.android.githubuser.ui.base

interface ImageLoader<T> {
    fun loadInto(url: String, container: T)
}