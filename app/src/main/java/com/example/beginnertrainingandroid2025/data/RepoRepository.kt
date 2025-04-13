package com.example.beginnertrainingandroid2025.data

class RepoRepository(
    private val remoteDataSource: RepoRemoteDataSource,
) {
    suspend fun getRepos(): List<Repo> = remoteDataSource.getRepos()
}