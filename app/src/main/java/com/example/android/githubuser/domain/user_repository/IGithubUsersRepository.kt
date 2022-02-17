package com.example.android.githubuser.domain.user_repository

import com.example.android.githubuser.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepository {

    fun getUsers(): Single<List<GithubUserModel>>
}