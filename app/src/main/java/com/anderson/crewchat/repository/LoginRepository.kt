package com.anderson.crewchat.repository

import com.anderson.crewchat.db.UserDao
import com.anderson.crewchat.model.User
import com.anderson.crewchat.service.DazoneService
import javax.inject.Inject


class LoginRepository
@Inject constructor(private val userDao: UserDao, private val dazoneService: DazoneService)
{
    suspend fun insertUser(user: User) = userDao.insertUser(user)
    fun getUser() = userDao.getUser()
    suspend fun checkSSL() = dazoneService.checkSSL()
}