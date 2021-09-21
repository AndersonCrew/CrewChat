package com.anderson.crewchat.model

import com.google.gson.annotations.SerializedName

class BaseResponse<out T> {
    @SerializedName("d")
    private var d: T?= null

    class Response<out T> {
        @SerializedName("data")
        private val data: T?= null

        @SerializedName("success")
        private val success: Int?= null

        @SerializedName("error")
        private val errorApi: ErrorApi?= null

    }

    data class ErrorApi(
        @SerializedName("code")
        private val code: Int?= null,

        @SerializedName("message")
        private val message: String?= null
    )
}