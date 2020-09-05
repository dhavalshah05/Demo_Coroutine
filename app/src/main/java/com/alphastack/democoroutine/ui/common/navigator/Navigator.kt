package com.alphastack.democoroutine.ui.common.navigator

import com.alphastack.democoroutine.ui.asyncAwait.AsyncAwaitFragment
import com.alphastack.democoroutine.ui.common.activity.BaseActivity
import com.ncapdevi.fragnav.FragNavController

class Navigator(
        private val activity: BaseActivity,
        private val fragNavController: FragNavController
) {

    fun navigateBack() {
        if (fragNavController.isRootFragment) {
            activity.onBackPressed()
        } else {
            fragNavController.popFragment()
        }
    }

    fun navigateToAsyncAwaitScreen() {
        fragNavController.pushFragment(AsyncAwaitFragment())
    }

}