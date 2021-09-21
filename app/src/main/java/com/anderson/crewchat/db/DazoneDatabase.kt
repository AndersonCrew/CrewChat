package com.anderson.crewchat.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anderson.crewchat.model.User


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class DazoneDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}