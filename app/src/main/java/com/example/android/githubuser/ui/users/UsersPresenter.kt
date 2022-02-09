package com.example.android.githubuser.ui.users

import com.example.android.githubuser.domain.GithubUsersRepo
import com.example.android.githubuser.screens.IScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val githubUsersRepository: GithubUsersRepo,
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
        viewState.updateList(users)
    }


//            githubUsersRepository.getUsers().subscribe( //rxJava subscribe on data
//            { item ->
//                usersListPresenter.users.add(item)
//                println("onNext: $item")
//
//            },
//            { throwable ->
//                println("onError: ${throwable.message}")
//            },
//            {
//                viewState.updateList()
//                println("onComplete")
//            }
//        )
//    }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    fun onUserClicked() {
        TODO("Not yet implemented")
    }

}