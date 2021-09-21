package com.anderson.crewchat

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CompletionHandlerException
import kotlinx.coroutines.CoroutineExceptionHandler

abstract class BaseViewModel: ViewModel() {
    protected val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->

    }
}