package com.alphastack.democoroutine.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alphastack.democoroutine.R
import kotlinx.android.synthetic.main.home_fragment.view.*

class HomeUIViewImpl(
        inflater: LayoutInflater,
        parent: ViewGroup?
) : HomeUIView() {

    init {
        setRootView(inflater.inflate(R.layout.home_fragment, parent, false))
        setUpViews()
        setUpViewListeners()
    }

    private fun setUpViews() {

    }

    private fun setUpViewListeners() {
        getRootView().buttonAsyncAwait.setOnClickListener {
            getListeners().forEach { it.onAsyncAwaitClicked() }
        }
        getRootView().buttonCountDownTimer.setOnClickListener {
            getListeners().forEach { it.onCountdownTimerClicked() }
        }
        getRootView().buttonLogin.setOnClickListener {
            getListeners().forEach { it.onLoginClicked() }
        }
    }

}