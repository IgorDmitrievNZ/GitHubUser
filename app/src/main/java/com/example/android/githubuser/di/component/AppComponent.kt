package com.example.android.githubuser.di.component

import com.example.android.githubuser.di.modules.*
import com.example.android.githubuser.ui.main.MainActivity
import com.example.android.githubuser.ui.main.MainPresenter
import com.example.android.githubuser.ui.repos.ReposPresenter
import com.example.android.githubuser.ui.users.UsersPresenter
import com.example.android.githubuser.ui.users_details.UserDetailsPresenter
import dagger.Component
import javax.inject.Singleton


@Component(
    modules = [
        ContextModule::class,
        NavigationModule::class,
        DbModule::class,
        NetworkModule::class,
        RepositoryModule::class,
    ]
)
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(mainPresenter: MainPresenter)

    fun inject(usersPresenter: UsersPresenter)

    fun inject(reposPresenter: ReposPresenter)

    fun inject(usersDetailsPresenter: UserDetailsPresenter)
}