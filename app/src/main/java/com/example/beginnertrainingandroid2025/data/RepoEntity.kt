package com.example.beginnertrainingandroid2025.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "repo",
)
data class RepoEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String? = null,
    val stars: Int,
)

fun RepoEntity.toModel() = Repo(
    id = id,
    name = name,
    description = description,
    stars = stars,
)

fun Repo.toEntity() = RepoEntity(
    id = id,
    name = name,
    description = description,
    stars = stars,
)

fun Repo.toBookmarkEntity() = BookmarkRepoEntity(
    repoId = id,
)