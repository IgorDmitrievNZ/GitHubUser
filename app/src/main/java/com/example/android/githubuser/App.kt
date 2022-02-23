package com.example.android.githubuser

import android.app.Application
import com.example.android.githubuser.di.component.DaggerAppComponent
import com.example.android.githubuser.di.modules.ContextModule

class App : Application() {

    val appComponent by lazy {
        DaggerAppComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        _instance = this

//        networkStatus.networkStatusSubject.subscribe {
//            Log.d("NetworkStatus", "Is network available: $it")
//        }
    }

    companion object {
        private var _instance: App? = null
        val instance
            get() = _instance!!
    }
}