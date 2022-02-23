package com.example.android.githubuser.ui.repos

import com.example.android.githubuser.domain.model.GithubUserModel
import com.example.android.githubuser.domain.repo_detail_repository.IGitHubRepositoryDetail
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class ReposPresenter @AssistedInject constructor(
    @Assisted private val userModel: GithubUserModel,
    private val githubRepositoryDetail: IGitHubRepositoryDetail,
    private val router: Router,
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

@AssistedFactory
interface ReposPresenterFactory {

    fun presenter(userModel: GithubUserModel): ReposPresenter
}