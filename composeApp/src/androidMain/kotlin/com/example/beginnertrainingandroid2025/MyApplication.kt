package com.example.beginnertrainingandroid2025

import android.app.Application
import com.example.beginnertrainingandroid2025.data.getAppDatabase
import com.example.beginnertrainingandroid2025.di.LocalDataSourceFactory

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        LocalDataSourceFactory.initialize(getAppDatabase(this).build())
    }
}