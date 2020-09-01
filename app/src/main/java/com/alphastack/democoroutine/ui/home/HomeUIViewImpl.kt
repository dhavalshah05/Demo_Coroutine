package com.alphastack.democoroutine.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alphastack.democoroutine.R

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

    }

}