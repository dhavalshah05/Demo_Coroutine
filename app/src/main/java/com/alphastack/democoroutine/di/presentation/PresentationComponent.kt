package com.alphastack.democoroutine.di.presentation

import com.alphastack.democoroutine.ui.MainActivity
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class])
interface PresentationComponent {
    fun inject(mainActivity: MainActivity)
}