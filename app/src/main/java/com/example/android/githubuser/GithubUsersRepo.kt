package com.example.android.githubuser

class GithubUsersRepo {
    private val repositories =
        (0..100).map { GithubUser("login $it") }

    fun getUsers() = repositories
}