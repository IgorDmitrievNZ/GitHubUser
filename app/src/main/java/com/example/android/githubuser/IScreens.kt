package com.example.android.githubuser

import android.os.Bundle
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun details(bundle: Bundle): Screen
}
