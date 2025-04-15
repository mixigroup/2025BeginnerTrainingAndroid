package com.example.beginnertrainingandroid2025

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.window.ComposeUIViewController
import com.example.beginnertrainingandroid2025.data.getAppDatabase
import com.example.beginnertrainingandroid2025.di.LocalDataSourceFactory

fun MainViewController() = ComposeUIViewController {
    LaunchedEffect(Unit) {
        LocalDataSourceFactory.initialize(getAppDatabase().build())
    }

    App()
}