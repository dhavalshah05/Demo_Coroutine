package com.alphastack.democoroutine.ui.login

data class ResponseBody<T>(val responseCode: Int,
                           val message: String,
                           val data: T?)