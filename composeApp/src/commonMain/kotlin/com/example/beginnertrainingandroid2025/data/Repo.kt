package com.example.beginnertrainingandroid2025.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Repo(
    val id: Int,
    val name: String,
    val description: String? = null,
    @SerialName("stargazers_count") val stars: Int,
)
