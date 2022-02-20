package com.example.android.githubuser.ui.users_details

import com.example.android.githubuser.domain.model.GithubUserModel
import com.example.android.githubuser.screens.IScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserDetailsPresenter(
    private val router: Router,
    private val screens: IScreens
) :
    MvpPresenter<UserDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setUserData()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    fun onReposClicked(userModel: GithubUserModel) {
        router.navigateTo(screens.repos(userModel))
    }
}