package com.example.android.githubuser.ui.users_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.android.githubuser.databinding.FragmentUserDetailsBinding
import com.example.android.githubuser.domain.model.GithubUserModel
import com.example.android.githubuser.ui.base.BackButtonListener
import com.example.android.githubuser.ui.base.GlideImageLoader
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserDetailsFragment : MvpAppCompatFragment(), UserDetailsView, BackButtonListener {

    private val userModel by lazy {
        requireArguments().getParcelable<GithubUserModel>(KEY_USERS)!!
    }

    private val presenter by moxyPresenter {
        UserDetailsPresenter()
    }
    private var _binding: FragmentUserDetailsBinding? = null
    private val binding get() = _binding!!
    private val imageLoader by lazy { GlideImageLoader() }

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
            presenter.onReposClicked(userModel)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun setUserData() {
        arguments?.let {
            val user = it.getParcelable<GithubUserModel>(KEY_USERS)
            user?.let {
                binding.userLogin.text = user.login
                user.avatarUrl?.let { url -> imageLoader.loadInto(url, binding.profilePhoto) }
            }
        }
    }

    override fun backPressed() = presenter.backPressed()


    companion object {
        const val KEY_USERS = "KEY_USERS"

        fun newInstance(user: GithubUserModel): UserDetailsFragment {
            return UserDetailsFragment().apply {
                this.arguments = bundleOf(KEY_USERS to user)
            }
        }
    }


}