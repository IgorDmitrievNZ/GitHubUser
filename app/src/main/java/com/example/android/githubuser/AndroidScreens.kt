package com.example.android.githubuser

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun details(bundle: Bundle) = FragmentScreen { UserDetailsFragment.newInstance(bundle) }
}