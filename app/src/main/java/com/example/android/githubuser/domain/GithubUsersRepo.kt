package com.example.android.githubuser.domain

import com.example.android.githubuser.model.GithubUser

class GithubUsersRepo {
    private val repositories =
        (1..100).map { GithubUser("login $it") }


//    fun getUsers(): Observable<GithubUser> {
//        return Observable.fromIterable(repositories)
//    }

    fun getUsers() = repositories
}