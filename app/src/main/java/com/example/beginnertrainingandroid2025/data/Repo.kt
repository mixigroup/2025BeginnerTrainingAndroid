package com.example.beginnertrainingandroid2025.data

data class Repo(
    val id: Int,
    val name: String,
    val description: String? = null,
    val stars: Int,
)
