package com.example.android.githubuser.domain.user_repository

import com.example.android.githubuser.domain.model.GithubUserModel
import com.example.android.githubuser.network.GithubApiService
import io.reactivex.rxjava3.core.Single

class GithubUsersRepo(private val githubApiService: GithubApiService) : IGithubUsersRepository {

    override fun getUsers(): Single<List<GithubUserModel>> {
        return githubApiService.getUsers()
    }

//    private val repositories =
//        (1..100).map { GithubUser("login $it") } //old data
//
//    fun getUsers() = repositories
}