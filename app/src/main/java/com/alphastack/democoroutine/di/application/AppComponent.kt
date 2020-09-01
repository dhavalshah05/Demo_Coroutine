package com.alphastack.democoroutine.di.application

import com.alphastack.democoroutine.di.activity.ActivityComponent
import com.alphastack.democoroutine.di.activity.ActivityModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent
}