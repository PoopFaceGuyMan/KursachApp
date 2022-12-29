package com.KursachApp

import android.annotation.SuppressLint
import android.app.Application

class WorkoutFreeApplication : Application() {

    @SuppressLint("MissingPermission")
    override fun onCreate() {
        super.onCreate()
    }
}