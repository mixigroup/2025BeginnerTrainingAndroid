package com.example.beginnertrainingandroid2025.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class RepoRemoteDataSource {
    suspend fun getRepoList(): List<Repo> = withContext(Dispatchers.IO) {
        List(100) {
            Repo(
                id = it,
                name = "repo$it",
                description = "this is awesome",
                stars = it,
            )
        }
    }
}