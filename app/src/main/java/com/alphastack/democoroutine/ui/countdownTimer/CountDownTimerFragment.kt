package com.alphastack.democoroutine.ui.countdownTimer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alphastack.democoroutine.di.presentation.PresentationComponent
import com.alphastack.democoroutine.ui.common.fragment.BaseFragment
import kotlinx.coroutines.*
import timber.log.Timber

class CountDownTimerFragment : BaseFragment(), CountDownTimerUIView.Listener {

    private lateinit var uiView: CountDownTimerUIView

    private val scope = CoroutineScope(Dispatchers.Main)

    override fun injectFragment(presentationComponent: PresentationComponent) {
        presentationComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        uiView = uiViewFactory.getCountDownTimerUIView(container)
        return uiView.getRootView()
    }

    override fun onStart() {
        super.onStart()
        uiView.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        uiView.unregisterListener(this)
        stopTimer()
    }

    override fun onNavigateUpClicked() {
        navigator.navigateBack()
    }

    override fun onStartTimerClicked() {
        startTimer()
        uiView.disableStartTimerButton()
    }

    override fun onStopTimerClicked() {
        stopTimer()
    }

    private fun stopTimer() {
        scope.coroutineContext.cancelChildren()
        uiView.clearTime()
        uiView.enableStartTimerButton()
    }

    private fun startTimer() {
        val totalSeconds = 10
        var currentSecond = 0

        scope.launch {
            while (totalSeconds >= currentSecond) {
                val time = totalSeconds - currentSecond
                Timber.d("Countdown Time: $time")
                uiView.bindTime(time.toString())

                if (totalSeconds != currentSecond) {
                    withContext(Dispatchers.Default) {
                        delay(1000)
                    }
                    currentSecond += 1
                } else {
                    break
                }
            }

            Timber.d("Timer Completed")
            uiView.bindTime("Done!")
            uiView.enableStartTimerButton()
        }
    }

}