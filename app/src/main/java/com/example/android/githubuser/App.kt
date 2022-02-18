package com.example.android.githubuser

import android.app.Application
import android.util.Log
import com.example.android.githubuser.db.GithubDatabase
import com.example.android.githubuser.network.NetworkStatus
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class App : Application() {

    //Temporarily. While can't use Dagger just put it here
    private val cicerone: Cicerone<Router> by lazy { Cicerone.create() }
    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val router get() = cicerone.router
    
    val database by lazy {
        GithubDatabase.getInstance(this)
    }

    private val networkStatus by lazy { NetworkStatus(this) }

    override fun onCreate() {
        super.onCreate()
        _instance = this

        networkStatus.networkStatusSubject.subscribe {
            Log.d("NetworkStatus", "Is network available: $it")
        }
    }

    companion object {
        private var _instance: App? = null
        val instance
            get() = _instance!!
    }
}