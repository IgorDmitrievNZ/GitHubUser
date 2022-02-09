package com.example.android.githubuser.screens

import com.example.android.githubuser.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
//    override fun details(bundle: Bundle) = FragmentScreen { UserDetailsFragment.newInstance(bundle) }
}