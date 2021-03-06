package com.example.android.githubuser.screens

import com.example.android.githubuser.domain.model.GithubUserModel
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun details(userDetails: GithubUserModel): Screen
    fun repos(userModel: GithubUserModel): Screen

}
