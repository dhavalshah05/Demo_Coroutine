package com.alphastack.democoroutine.ui.home

import com.alphastack.democoroutine.ui.common.uiView.BaseObservableUIView

abstract class HomeUIView: BaseObservableUIView<HomeUIView.Listener>() {

    interface Listener {
        fun onAsyncAwaitClicked()
    }

}