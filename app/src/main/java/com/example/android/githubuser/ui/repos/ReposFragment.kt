package com.example.android.githubuser.ui.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import com.example.android.githubuser.App
import com.example.android.githubuser.databinding.FragmentReposBinding
import com.example.android.githubuser.domain.model.GitHubRepoDetailModel
import com.example.android.githubuser.domain.model.GithubUserModel
import com.example.android.githubuser.ui.base.BackButtonListener
import com.example.android.githubuser.ui.repos.adapter.ReposAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ReposFragment : MvpAppCompatFragment(), ReposView, BackButtonListener {

    private val userModel by lazy {
        requireArguments().getParcelable<GithubUserModel>(KEY_USER_MODEL)!!
    }

    private val presenter by moxyPresenter {
       // ReposPresenter(userModel)
        App.instance.appComponent.provideReposPresenterFactory().presenter(userModel)
    }

    private val adapter by lazy { ReposAdapter() { presenter.onItemClicked() } }
    private var _binding: FragmentReposBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReposBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

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