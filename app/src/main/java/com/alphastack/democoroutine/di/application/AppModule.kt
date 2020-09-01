package com.alphastack.democoroutine.di.application

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application) {

    @Provides
    fun provideApplication(): Application = application

}