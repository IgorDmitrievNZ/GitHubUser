package com.example.android.githubuser.ui.users

import com.example.android.githubuser.domain.model.GithubUserModel
import com.example.android.githubuser.domain.user_repository.IGithubUsersRepository
import com.example.android.githubuser.screens.IScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UsersPresenter @Inject constructor(
    private val githubUsersRepository: IGithubUsersRepository,
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<UsersView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        //App.instance.appComponent.inject(this)   //not required because we use @Inject constructor
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