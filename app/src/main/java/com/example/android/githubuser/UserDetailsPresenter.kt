package com.example.android.githubuser

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserDetailsPresenter(private val router: Router) : MvpPresenter<UserDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setUserData()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}