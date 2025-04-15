package com.example.beginnertrainingandroid2025.data

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSHomeDirectory

fun getAppDatabase(): RoomDatabase.Builder<AppDatabase> {
    val dbFile = NSHomeDirectory() + "/user.db"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile,
    )
        .fallbackToDestructiveMigrationOnDowngrade(true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
}
