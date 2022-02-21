package com.example.android.githubuser.ui.repos

import com.example.android.githubuser.domain.model.GithubUserModel
import com.example.android.githubuser.domain.repo_detail_repository.IGitHubRepositoryDetail
import com.example.android.githubuser.screens.IScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class ReposPresenter(
    private val githubRepositoryDetail: IGitHubRepositoryDetail,
    private val userModel: GithubUserModel,
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<ReposView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        val repos = githubRepositoryDetail.getReposDetails(userModel)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { repos ->
                    viewState.updateList(repos)
                }, {
                    viewState.showError(it.message)
                }
            )
    }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    fun onItemClicked() {

        // implement later
    }

}