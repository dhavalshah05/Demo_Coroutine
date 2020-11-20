package com.alphastack.democoroutine.ui.login

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.lang.RuntimeException

object LoginAPI {

    suspend fun loginUser(userName: String, password: String): ResponseBody<Boolean> {
        return withContext(Dispatchers.IO) {
            delay(2000)
            ResponseBody(200, "Success", true)
            //ResponseBody(11, "Failure", true)
            //throw RuntimeException("asdasdasd")
        }
    }

}