package com.anderson.crewchat.viewmodel

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.anderson.crewchat.BaseViewModel
import com.anderson.crewchat.model.User
import com.anderson.crewchat.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository) :
    BaseViewModel() {

    fun insertUser(user: User) = viewModelScope.launch {
        repository.insertUser(user)
    }

    fun getUser() = repository.getUser().asLiveData()

    fun checkSSL() = viewModelScope.launch {
        repository.checkSSL().asLiveData()
    }
}