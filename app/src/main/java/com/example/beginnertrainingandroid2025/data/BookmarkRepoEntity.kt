package com.example.beginnertrainingandroid2025.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "bookmark_repo",
    primaryKeys = ["repo_id"],
    foreignKeys = [
        ForeignKey(
            entity = RepoEntity::class,
            parentColumns = ["id"],
            childColumns = ["repo_id"],
            onDelete = ForeignKey.CASCADE,
        )
    ]
)
data class BookmarkRepoEntity(
    @ColumnInfo("repo_id") val repoId: Int,
)
