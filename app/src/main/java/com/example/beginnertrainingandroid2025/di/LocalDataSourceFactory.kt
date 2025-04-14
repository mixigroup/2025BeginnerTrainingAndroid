package com.example.beginnertrainingandroid2025.di

import android.app.Application
import androidx.room.Room
import com.example.beginnertrainingandroid2025.data.AppDatabase
import com.example.beginnertrainingandroid2025.data.RepoLocalDataSource

object LocalDataSourceFactory {
    private lateinit var appDatabase: AppDatabase

    fun initialize(app: Application) {
        appDatabase =  Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "app_database",
        ).build()
    }

    fun createRepoLocalDataSource() = RepoLocalDataSource(dao = appDatabase.repoDao())
}
