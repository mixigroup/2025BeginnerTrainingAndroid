package com.example.beginnertrainingandroid2025.data

class RepoRepository(
    private val localDataSource: RepoLocalDataSource,
    private val remoteDataSource: RepoRemoteDataSource,
) {
    suspend fun getRepoList(): List<Repo> {
        return localDataSource.getRepoList().ifEmpty {
            val repoList = remoteDataSource.getRepoList()
            localDataSource.saveRepoList(repoList)
            repoList
        }
    }

    suspend fun saveAsBookmark(repo: Repo) {
        localDataSource.saveAsBookmark(repo)
    }

    suspend fun saveAsUnBookmark(repo: Repo) {
        localDataSource.saveAsUnBookmark(repo)
    }

    suspend fun getBookmarkedRepoList(): List<Repo> {
        return localDataSource.getBookmarkRepoList()
    }}