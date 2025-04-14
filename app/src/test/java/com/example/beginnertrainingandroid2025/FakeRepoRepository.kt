package com.example.beginnertrainingandroid2025

import com.example.beginnertrainingandroid2025.data.Repo
import com.example.beginnertrainingandroid2025.data.RepoRepository
import kotlinx.coroutines.delay

class FakeRepoRepository(
    private val repos: List<Repo>,
    bookmarkedRepos: List<Repo>,
) : RepoRepository {
    private val _bookmarkedRepos: MutableList<Repo> = bookmarkedRepos.toMutableList()

    override suspend fun getRepoList(): List<Repo> {
        delay(100)
        return repos
    }

    override suspend fun saveAsBookmark(repo: Repo) {
        delay(100)
        _bookmarkedRepos.add(repo)
    }

    override suspend fun saveAsUnBookmark(repo: Repo) {
        delay(100)
        _bookmarkedRepos.remove(repo)
    }

    override suspend fun getBookmarkedRepoList(): List<Repo> {
        delay(100)
        return _bookmarkedRepos
    }
}
