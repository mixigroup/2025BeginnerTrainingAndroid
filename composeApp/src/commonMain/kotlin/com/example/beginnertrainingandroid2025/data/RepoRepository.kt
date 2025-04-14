package com.example.beginnertrainingandroid2025.data

interface RepoRepository {
    suspend fun getRepoList(): List<Repo>

    suspend fun saveAsBookmark(repo: Repo)

    suspend fun saveAsUnBookmark(repo: Repo)

    suspend fun getBookmarkedRepoList(): List<Repo>
}
