package com.example.android.githubuser

import android.os.Bundle
import com.example.android.githubuser.UserDetailsFragment.Companion.EXTRA_BUNDLE
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    val usersRepository: GithubUsersRepo,
    val router: Router,
    val screens: IScreens
) :
    MvpPresenter<UsersView>() {

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            val bundle = Bundle().apply {
                this.putParcelable(EXTRA_BUNDLE, usersListPresenter.users[itemView.pos])
            }
            // switch to user screen
            router.navigateTo(screens.details(bundle)) //NAVIGATION cicerone
        }
    }

    private fun loadData() {
        val users = usersRepository.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}