package com.example.android.githubuser.ui.users

import com.example.android.githubuser.model.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView : MvpView {
//    fun init()
//    fun updateList(users: Observable<GithubUser>)
fun updateList(users: List<GithubUser>)
}