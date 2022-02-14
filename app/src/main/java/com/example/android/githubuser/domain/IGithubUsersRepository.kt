package com.example.android.githubuser.domain

import com.example.android.githubuser.model.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepository {

    fun getUsers(): Single<List<GithubUser>>
}