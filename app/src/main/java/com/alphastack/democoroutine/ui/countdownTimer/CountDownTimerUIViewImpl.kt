package com.alphastack.democoroutine.ui.countdownTimer

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alphastack.democoroutine.R
import kotlinx.android.synthetic.main.count_down_timer_fragment.view.*

class CountDownTimerUIViewImpl(
        inflater: LayoutInflater,
        parent: ViewGroup?
) : CountDownTimerUIView() {

    init {
        setRootView(inflater.inflate(R.layout.count_down_timer_fragment, parent, false))
        setUpViews()
        setUpViewListeners()
    }

    private fun setUpViews() {

    }

    private fun setUpViewListeners() {
        getRootView().buttonStartTimer.setOnClickListener {
            getListeners().forEach { it.onStartTimerClicked() }
        }
        getRootView().buttonStopTimer.setOnClickListener {
            getListeners().forEach { it.onStopTimerClicked() }
        }
        getRootView().toolbar.setNavigationOnClickListener {
            getListeners().forEach { it.onNavigateUpClicked() }
        }
    }

    override fun bindTime(time: String) {
        getRootView().textViewTime.text = time
    }

    override fun clearTime() {
        bindTime("")
    }

    override fun enableStartTimerButton() {
        getRootView().buttonStartTimer.isEnabled = true
        getRootView().buttonStopTimer.isEnabled = false
    }

    override fun disableStartTimerButton() {
        getRootView().buttonStartTimer.isEnabled = false
        getRootView().buttonStopTimer.isEnabled = true
    }

}