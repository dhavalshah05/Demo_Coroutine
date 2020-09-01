package com.alphastack.democoroutine

import android.app.Application
import com.alphastack.democoroutine.di.application.AppComponent
import com.alphastack.democoroutine.di.application.AppModule
import com.alphastack.democoroutine.di.application.DaggerAppComponent
import com.alphastack.democoroutine.utils.logging.ClickableLoggingTree
import timber.log.Timber

class StarterApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        setUpLogging()
    }

    private fun setUpLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(ClickableLoggingTree())
        }
    }

}