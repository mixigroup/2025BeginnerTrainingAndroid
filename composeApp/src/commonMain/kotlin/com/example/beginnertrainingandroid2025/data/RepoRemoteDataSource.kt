package com.example.beginnertrainingandroid2025.data

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class RepoRemoteDataSource {
    suspend fun getRepoList(): List<Repo> = withContext(Dispatchers.IO) {
        httpClient.get("https://api.github.com/orgs/mixigroup/repos").body()
    }
}