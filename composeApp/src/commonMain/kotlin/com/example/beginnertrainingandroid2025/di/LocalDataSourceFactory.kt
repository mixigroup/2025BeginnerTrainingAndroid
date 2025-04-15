package com.example.beginnertrainingandroid2025.di

import com.example.beginnertrainingandroid2025.data.AppDatabase
import com.example.beginnertrainingandroid2025.data.RepoLocalDataSource

object LocalDataSourceFactory {
    private lateinit var db: AppDatabase

    fun initialize(appDatabase: AppDatabase) {
        db = appDatabase
    }

    fun createRepoLocalDataSource() = RepoLocalDataSource(dao = db.repoDao())
}