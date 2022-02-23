package com.example.android.githubuser.ui.users_details

import com.example.android.githubuser.App
import com.example.android.githubuser.domain.model.GithubUserModel
import com.example.android.githubuser.screens.IScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class UserDetailsPresenter : MvpPresenter<UserDetailsView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        App.instance.appComponent.inject(this)
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