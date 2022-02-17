package com.example.android.githubuser.network

import com.example.android.githubuser.model.GitHubRepoDetailModel
import com.example.android.githubuser.model.GithubUserModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface GithubApiService {

    @GET("/users")
    fun getUsers(): Single<List<GithubUserModel>>

    @GET
    fun getRepositories(@Url url: String): Single<List<GitHubRepoDetailModel>>
}