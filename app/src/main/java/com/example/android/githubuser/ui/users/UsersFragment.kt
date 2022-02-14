package com.example.android.githubuser.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.android.githubuser.App
import com.example.android.githubuser.databinding.FragmentUsersBinding
import com.example.android.githubuser.domain.GithubUsersRepo
import com.example.android.githubuser.model.GithubUser
import com.example.android.githubuser.network.ApiHolder
import com.example.android.githubuser.screens.AndroidScreens
import com.example.android.githubuser.ui.base.BackButtonListener
import com.example.android.githubuser.ui.base.GlideImageLoader
import com.example.android.githubuser.ui.users.adapter.UsersRVAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    private val presenter by moxyPresenter {
        UsersPresenter(
            GithubUsersRepo(ApiHolder.githubApiService),
            App.instance.router,
            AndroidScreens()
        )
    }
    private val adapter by lazy { UsersRVAdapter(GlideImageLoader()) { presenter.onUserClicked() } }
    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvUsers.adapter = adapter
    }

    override fun updateList(users: List<GithubUser>) {
        adapter.submitList(users)
    }

    override fun showError(message: String?) {
        Toast.makeText(requireContext(), message.orEmpty(), Toast.LENGTH_SHORT)
            .show()
    }

    override fun backPressed() = presenter.backPressed()

    companion object {

        fun newInstance() =  UsersFragment()
    }

}

