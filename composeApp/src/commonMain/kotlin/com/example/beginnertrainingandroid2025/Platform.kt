package com.example.beginnertrainingandroid2025

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform