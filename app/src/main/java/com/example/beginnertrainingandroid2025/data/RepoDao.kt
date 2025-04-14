package com.example.beginnertrainingandroid2025.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RepoDao {
    @Query("SELECT * FROM repo")
    suspend fun findAll(): List<RepoEntity>

    @Insert
    suspend fun insertAll(vararg repos: RepoEntity)

    @Insert
    suspend fun insertBookmark(repo: BookmarkRepoEntity)

    @Delete
    suspend fun deleteBookmark(repo: BookmarkRepoEntity)

    @Query("""
        SELECT * 
        FROM repo
        WHERE id IN bookmark_repo
    """)
    suspend fun findAllBookmark(): List<RepoEntity>
}
