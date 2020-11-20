package com.alphastack.democoroutine.ui.common.uiView

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alphastack.democoroutine.ui.asyncAwait.AsyncAwaitUIView
import com.alphastack.democoroutine.ui.asyncAwait.AsyncAwaitUIViewImpl
import com.alphastack.democoroutine.ui.countdownTimer.CountDownTimerUIView
import com.alphastack.democoroutine.ui.countdownTimer.CountDownTimerUIViewImpl
import com.alphastack.democoroutine.ui.home.HomeUIView
import com.alphastack.democoroutine.ui.home.HomeUIViewImpl
import com.alphastack.democoroutine.ui.login.LoginUIView
import com.alphastack.democoroutine.ui.login.LoginUIViewImpl
import javax.inject.Inject

class UIViewFactory @Inject constructor(
        private val layoutInflater: LayoutInflater
) {

    fun getHomeUIView(parent: ViewGroup?): HomeUIView {
        return HomeUIViewImpl(layoutInflater, parent)
    }

    fun getAsyncAwaitUIView(parent: ViewGroup?): AsyncAwaitUIView {
        return AsyncAwaitUIViewImpl(layoutInflater, parent)
    }

    fun getCountDownTimerUIView(parent: ViewGroup?): CountDownTimerUIView {
        return CountDownTimerUIViewImpl(layoutInflater, parent)
    }

    fun getLoginUIView(parent: ViewGroup?): LoginUIView {
        return LoginUIViewImpl(layoutInflater, parent)
    }

}