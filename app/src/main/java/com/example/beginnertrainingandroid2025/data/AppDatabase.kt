package com.example.beginnertrainingandroid2025.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        RepoEntity::class,
        BookmarkRepoEntity::class,
    ],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao
}
