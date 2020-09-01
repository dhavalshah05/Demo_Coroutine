package com.alphastack.democoroutine.di.activity

import com.alphastack.democoroutine.di.presentation.PresentationComponent
import com.alphastack.democoroutine.di.presentation.PresentationModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent
}