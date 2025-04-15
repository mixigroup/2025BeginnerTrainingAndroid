package com.example.beginnertrainingandroid2025

actual object AppConfig {
    actual val GITHUB_API_TOKEN: String
        get() = BuildConfig.GITHUB_API_TOKEN
}
