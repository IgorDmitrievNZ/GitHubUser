package com.example.android.githubuser

import io.reactivex.rxjava3.core.Observable

class GithubUsersRepo {
    private val repositories =
        (1..100).map { GithubUser("login $it") }


    fun getUsers(): Observable<GithubUser> {
        return Observable.fromIterable(repositories)
    }
}