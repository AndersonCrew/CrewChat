package com.anderson.crewchat.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "USER")
class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val userName: String,
    val password: String

)