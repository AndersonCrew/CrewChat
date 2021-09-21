package com.anderson.crewchat.repository

import com.anderson.crewchat.db.UserDao
import com.anderson.crewchat.model.User
import com.anderson.crewchat.service.DazoneNonService
import javax.inject.Inject


class LoginRepository
@Inject constructor(private val userDao: UserDao, private val dazoneNonService: DazoneNonService)
{
    suspend fun insertUser(user: User) = userDao.insertUser(user)
    fun getUser() = userDao.getUser()
    suspend fun checkSSL() = dazoneNonService.checkSSL()
}