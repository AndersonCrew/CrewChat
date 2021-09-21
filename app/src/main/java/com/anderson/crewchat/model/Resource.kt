package com.anderson.crewchat.model

class Resource<out T>(private val status: Status, private val data: T, private val message: String) {
    companion object {
        fun<T> success(data: T): Resource<T> = Resource(Status.SUCCESS, data, "Success")
        fun<T> error(data: T): Resource<T> = Resource(Status.FAIL, data, "Fail")
        fun<T> loading(data: T): Resource<T> = Resource(Status.LOADING, data, "Loading...!")
    }
}