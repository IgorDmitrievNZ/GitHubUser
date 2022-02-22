package com.example.android.githubuser.ui.users

import com.example.android.githubuser.App
import com.example.android.githubuser.domain.model.GithubUserModel
import com.example.android.githubuser.domain.user_repository.IGithubUsersRepository
import com.example.android.githubuser.screens.IScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UsersPresenter: MvpPresenter<UsersView>() {

    @Inject
    lateinit var githubUsersRepository: IGithubUsersRepository

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        App.instance.appComponent.inject(this)
        loadData()
    }

    private fun loadData() {
        val users = githubUsersRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { users ->
                    viewState.updateList(users)
                }, {
                    viewState.showError(it.message)
                }
            )
    }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    fun onUserClicked(user: GithubUserModel) {
             //switch to user screen
            router.navigateTo(screens.details(user)) //NAVIGATION cicerone
        }

}