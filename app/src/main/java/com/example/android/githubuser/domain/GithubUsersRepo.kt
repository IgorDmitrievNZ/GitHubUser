package com.example.android.githubuser.domain

import com.example.android.githubuser.model.GithubUser
import com.example.android.githubuser.network.GithubApiService
import io.reactivex.rxjava3.core.Single

class GithubUsersRepo(private val githubApiService: GithubApiService) : IGithubUsersRepository{

    override fun getUsers(): Single<List<GithubUser>> {
        return githubApiService.getUsers()
    }

//    private val repositories =
//        (1..100).map { GithubUser("login $it") } //old data
//
//    fun getUsers() = repositories
}