package com.example.android.githubuser.ui.users

import com.example.android.githubuser.domain.IGithubUsersRepository
import com.example.android.githubuser.screens.IScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UsersPresenter(
    private val githubUsersRepository: IGithubUsersRepository,
    private val router: Router,
    val screens: IScreens
) : MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()

//        usersListPresenter.itemClickListener = { itemView ->
//            val bundle = Bundle().apply {
//                this.putParcelable(EXTRA_BUNDLE, usersListPresenter.users[itemView.pos])
//            }
//             //switch to user screen
//            router.navigateTo(screens.details(bundle)) //NAVIGATION cicerone
//        }
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

    fun onUserClicked() {
        TODO("Not yet implemented")
    }

}