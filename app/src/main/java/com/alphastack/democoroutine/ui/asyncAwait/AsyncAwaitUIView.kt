package com.alphastack.democoroutine.ui.asyncAwait

import com.alphastack.democoroutine.ui.common.uiView.BaseObservableUIView

abstract class AsyncAwaitUIView: BaseObservableUIView<AsyncAwaitUIView.Listener>() {

    interface Listener {
        fun onNavigateUpClicked()
    }


}