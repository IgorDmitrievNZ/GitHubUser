package com.example.android.githubuser.ui.repos

import com.example.android.githubuser.App
import com.example.android.githubuser.domain.model.GithubUserModel
import com.example.android.githubuser.domain.repo_detail_repository.IGitHubRepositoryDetail
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class ReposPresenter(private val userModel: GithubUserModel) : MvpPresenter<ReposView>() {

    @Inject
    lateinit var githubRepositoryDetail: IGitHubRepositoryDetail

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        App.instance.appComponent.inject(this)
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