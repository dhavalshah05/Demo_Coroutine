package com.alphastack.democoroutine.ui.asyncAwait

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alphastack.democoroutine.R
import kotlinx.android.synthetic.main.async_await_fragment.view.*

class AsyncAwaitUIViewImpl(
        inflater: LayoutInflater,
        parent: ViewGroup?
) : AsyncAwaitUIView() {

    init {
        setRootView(inflater.inflate(R.layout.async_await_fragment, parent, false))
        setUpViews()
        setUpViewListeners()
    }

    private fun setUpViews() {

    }

    private fun setUpViewListeners() {
        getRootView().toolbar.setNavigationOnClickListener {
            getListeners().forEach { it.onNavigateUpClicked() }
        }
    }

}