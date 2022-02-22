package com.example.android.githubuser.ui.main

import com.example.android.githubuser.App
import com.example.android.githubuser.screens.IScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val router: Router,
    private val screens: IScreens,
) : MvpPresenter<MainView>() {

//    @Inject
//    lateinit var router: Router
//
//    @Inject
//    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
//        App.instance.appComponent.inject(this)
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }
}

