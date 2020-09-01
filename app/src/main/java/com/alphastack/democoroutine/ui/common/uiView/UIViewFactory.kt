package com.alphastack.democoroutine.ui.common.uiView

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alphastack.democoroutine.ui.home.HomeUIView
import com.alphastack.democoroutine.ui.home.HomeUIViewImpl
import javax.inject.Inject

class UIViewFactory @Inject constructor(
        private val layoutInflater: LayoutInflater
) {

    fun getHomeUIView(parent: ViewGroup?): HomeUIView {
        return HomeUIViewImpl(layoutInflater, parent)
    }

}