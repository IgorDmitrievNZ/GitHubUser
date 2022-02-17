package com.example.android.githubuser.ui.users_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.android.githubuser.App
import com.example.android.githubuser.databinding.FragmentUserDetailsBinding
import com.example.android.githubuser.model.GithubUserModel
import com.example.android.githubuser.screens.AndroidScreens
import com.example.android.githubuser.ui.base.BackButtonListener
import com.example.android.githubuser.ui.base.GlideImageLoader
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserDetailsFragment : MvpAppCompatFragment(), UserDetailsView, BackButtonListener {

    private val presenter by moxyPresenter {
        UserDetailsPresenter(
            App.instance.router,
            AndroidScreens()
        )
    }
    private var _binding: FragmentUserDetailsBinding? = null
    private val binding get() = _binding!!
    private val imageLoader by lazy { GlideImageLoader() }
    private var reposUrl: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.reposChip.setOnClickListener {
            presenter.onReposClicked(reposUrl)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun setUserData() {
        arguments?.let {
            val user = it.getParcelable<GithubUserModel>(EXTRA_BUNDLE)
            user?.let {
                binding.userLogin.text = user.login
                user.avatarUrl?.let { url -> imageLoader.loadInto(url, binding.profilePhoto) }
                reposUrl = user.reposUrl
            }
        }
    }

    override fun backPressed() = presenter.backPressed()


    companion object {
        const val EXTRA_BUNDLE = "EXTRA_BUNDLE"

        fun newInstance(user: GithubUserModel): UserDetailsFragment {
            return UserDetailsFragment().apply {
                this.arguments = bundleOf(EXTRA_BUNDLE to user)
            }
        }
    }


}