package com.alphastack.democoroutine.ui.common.navigator

import com.alphastack.democoroutine.ui.asyncAwait.AsyncAwaitFragment
import com.alphastack.democoroutine.ui.common.activity.BaseActivity
import com.alphastack.democoroutine.ui.countdownTimer.CountDownTimerFragment
import com.alphastack.democoroutine.ui.login.LoginFragment
import com.ncapdevi.fragnav.FragNavController

class Navigator(
        private val activity: BaseActivity,
        private val fragNavController: FragNavController
) {

    fun navigateBack() {
        if (fragNavController.isRootFragment) {
            activity.goBack()
        } else {
            fragNavController.popFragment()
        }
    }

    fun navigateToAsyncAwaitScreen() {
        fragNavController.pushFragment(AsyncAwaitFragment())
    }

    fun navigateToCountdownTimerScreen() {
        fragNavController.pushFragment(CountDownTimerFragment())
    }

    fun navigateToLoginScreen() {
        fragNavController.pushFragment(LoginFragment())
    }

}