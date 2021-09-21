package com.anderson.crewchat.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [], version = 1, exportSchema = true)
abstract class DazoneDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}