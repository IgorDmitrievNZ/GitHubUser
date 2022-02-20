package com.example.android.githubuser.screens

import com.example.android.githubuser.domain.model.GithubUserModel
import com.example.android.githubuser.ui.repos.ReposFragment
import com.example.android.githubuser.ui.users.UsersFragment
import com.example.android.githubuser.ui.users_details.UserDetailsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun details(userDetails: GithubUserModel) = FragmentScreen { UserDetailsFragment.newInstance(userDetails) }
    override fun repos(userModel: GithubUserModel) = FragmentScreen { ReposFragment.newInstance(userModel) }
}