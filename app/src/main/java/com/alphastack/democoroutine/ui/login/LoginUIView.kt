package com.alphastack.democoroutine.ui.login

import com.alphastack.democoroutine.ui.common.uiView.BaseObservableUIView

abstract class LoginUIView: BaseObservableUIView<LoginUIView.Listener>() {

    interface Listener {
        fun onLoginClicked()
    }

    abstract fun disableLogin()
    abstract fun enableLogin()
}