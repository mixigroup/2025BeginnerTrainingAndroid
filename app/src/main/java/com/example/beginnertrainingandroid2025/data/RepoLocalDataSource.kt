package com.example.beginnertrainingandroid2025.data

class RepoLocalDataSource(
    private val dao: RepoDao,
) {
    suspend fun getRepoList(): List<Repo> = dao.findAll().map { it.toModel() }

    suspend fun saveRepoList(repoList: List<Repo>) {
        dao.insertAll(*repoList.map { it.toEntity() }.toTypedArray())
    }

    suspend fun saveAsBookmark(repo: Repo) {
        dao.insertBookmark(repo.toBookmarkEntity())
    }

    suspend fun saveAsUnBookmark(repo: Repo) {
        dao.deleteBookmark(repo.toBookmarkEntity())
    }

    suspend fun getBookmarkRepoList(): List<Repo> {
        return dao.findAllBookmark().map { it.toModel() }
    }
}