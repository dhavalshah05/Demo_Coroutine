package com.alphastack.democoroutine.di.presentation

import com.alphastack.democoroutine.ui.asyncAwait.AsyncAwaitFragment
import com.alphastack.democoroutine.ui.countdownTimer.CountDownTimerFragment
import com.alphastack.democoroutine.ui.home.HomeFragment
import com.alphastack.democoroutine.ui.home.MainActivity
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class])
interface PresentationComponent {
    // Inject Activities
    fun inject(activity: MainActivity)

    // Inject Fragments
    fun inject(fragment: HomeFragment)
    fun inject(fragment: AsyncAwaitFragment)
    fun inject(fragment: CountDownTimerFragment)
}