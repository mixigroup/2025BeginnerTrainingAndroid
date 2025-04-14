package com.example.beginnertrainingandroid2025.data

class RepoLocalDataSource() {
    suspend fun getRepoList(): List<Repo> = emptyList()

    suspend fun saveRepoList(repoList: List<Repo>) {
    }

    suspend fun saveAsBookmark(repo: Repo) {
    }

    suspend fun saveAsUnBookmark(repo: Repo) {
    }

    suspend fun getBookmarkRepoList(): List<Repo> = emptyList()
}
