package com.alphastack.democoroutine.di.activity

import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    fun provideActivity(): AppCompatActivity = activity

}