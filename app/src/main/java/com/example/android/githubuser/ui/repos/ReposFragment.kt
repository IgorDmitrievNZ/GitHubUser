package com.example.android.githubuser.ui.repos

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import com.example.android.githubuser.App
import com.example.android.githubuser.R
import com.example.android.githubuser.databinding.FragmentReposBinding
import com.example.android.githubuser.domain.model.GitHubRepoDetailModel
import com.example.android.githubuser.domain.model.GithubUserModel
import com.example.android.githubuser.ui.base.BackButtonListener
import com.example.android.githubuser.ui.base.viewBinding
import com.example.android.githubuser.ui.repos.adapter.ReposAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ReposFragment : MvpAppCompatFragment(R.layout.fragment_repos), ReposView, BackButtonListener {

    private val userModel by lazy {
        requireArguments().getParcelable<GithubUserModel>(KEY_USER_MODEL)!!
    }

    private val presenter by moxyPresenter {
        // ReposPresenter(userModel)
        App.instance.appComponent.provideReposPresenterFactory().presenter(userModel)
    }

    private val adapter by lazy { ReposAdapter() { presenter.onItemClicked() } }
    private val binding: FragmentReposBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvRepos.adapter = adapter
    }

    override fun updateList(repos: List<GitHubRepoDetailModel>) {
        adapter.submitList(repos)
    }

    override fun showError(message: String?) {
        Toast.makeText(requireContext(), message.orEmpty(), Toast.LENGTH_SHORT)
            .show()
    }

    override fun backPressed() = presenter.backPressed()

    companion object {
        const val KEY_USER_MODEL = "KEY_USER_MODEL"

        fun newInstance(userModel: GithubUserModel): ReposFragment {
            return ReposFragment().apply {
                this.arguments = bundleOf(KEY_USER_MODEL to userModel)
            }
        }
    }
}