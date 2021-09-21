package com.anderson.crewchat

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DazoneApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}