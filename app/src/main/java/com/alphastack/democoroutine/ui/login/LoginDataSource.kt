package com.alphastack.democoroutine.ui.login

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object LoginDataSource {

    private suspend fun <T> execute(callback: suspend () -> ResponseBody<T>): DataWrapper<T> {
        return withContext(Dispatchers.Default) {
            val dataWrapper = try {
                val responseBody = callback.invoke()
                DataWrapper(responseBody, null)
            } catch (e: Throwable) {
                DataWrapper<T>(null, e)
            }

            if (dataWrapper.responseBody != null) {
                when (dataWrapper.responseBody.responseCode) {
                    0, 2, 3, 4, 11 -> {
                        return@withContext DataWrapper(dataWrapper.responseBody, ServerException(dataWrapper.responseBody.message, dataWrapper.responseBody.responseCode))
                    }
                }
            }

            dataWrapper
        }
    }

    suspend fun loginUser(userName: String, password: String): DataWrapper<Boolean> {
        return execute {
            LoginAPI.loginUser(userName, password)
        }
    }

}