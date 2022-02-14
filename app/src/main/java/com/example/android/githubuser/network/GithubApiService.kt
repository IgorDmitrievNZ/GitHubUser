package com.example.android.githubuser.network

import com.example.android.githubuser.model.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface GithubApiService {
    @GET("/users")
    fun getUsers(): Single<List<GithubUser>>
}