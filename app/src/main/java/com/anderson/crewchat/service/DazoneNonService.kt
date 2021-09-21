package com.anderson.crewchat.service

import com.anderson.crewchat.model.BaseResponse
import com.anderson.crewchat.model.SSL
import kotlinx.coroutines.flow.Flow
import retrofit2.http.POST

interface DazoneNonService {
    @POST("SSL_Check")
    suspend fun checkSSL(): Flow<BaseResponse<SSL>>
}