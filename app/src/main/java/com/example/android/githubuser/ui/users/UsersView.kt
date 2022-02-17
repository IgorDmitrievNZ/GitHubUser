package com.example.android.githubuser.ui.users

import com.example.android.githubuser.model.GithubUserModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip


interface UsersView : MvpView {

    @AddToEndSingle
    fun updateList(users: List<GithubUserModel>)

    @Skip
    fun showError(message: String?)
}