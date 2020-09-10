package com.alphastack.democoroutine.ui.countdownTimer

import com.alphastack.democoroutine.ui.common.uiView.BaseObservableUIView

abstract class CountDownTimerUIView: BaseObservableUIView<CountDownTimerUIView.Listener>() {

    interface Listener {
        fun onNavigateUpClicked()
        fun onStartTimerClicked()
        fun onStopTimerClicked()
    }

    abstract fun bindTime(time: String)
    abstract fun clearTime()
    abstract fun enableStartTimerButton()
    abstract fun disableStartTimerButton()
}