package com.example.android.githubuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.githubuser.databinding.FragmentUserDetailsBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserDetailsFragment : MvpAppCompatFragment(), UserDetailsView, BackButtonListener {

    private val presenter by moxyPresenter { UserDetailsPresenter(App.instance.router) }
    private var _binding: FragmentUserDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun setUserData() {
        arguments?.let {
            val user = it.getParcelable<GithubUser>(EXTRA_BUNDLE)
            user?.let {
                binding.userLogin.text = user.login
            }
        }
    }

    companion object {
        const val EXTRA_BUNDLE = "EXTRA_BUNDLE"

        fun newInstance(bundle: Bundle): UserDetailsFragment {
            return UserDetailsFragment().apply {
                this.arguments = bundle
            }
        }
    }

    override fun backPressed() = presenter.backPressed()
}