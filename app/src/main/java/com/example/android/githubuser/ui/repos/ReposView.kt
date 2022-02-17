package com.example.android.githubuser.ui.repos

import com.example.android.githubuser.model.GitHubRepoDetailModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface ReposView : MvpView {

    @AddToEndSingle
    fun updateList(repos: List<GitHubRepoDetailModel>)

    @Skip
    fun showError(message: String?)

}