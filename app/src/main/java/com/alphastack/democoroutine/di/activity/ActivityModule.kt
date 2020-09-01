package com.alphastack.democoroutine.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.alphastack.democoroutine.ui.common.activity.BaseActivity
import com.alphastack.democoroutine.ui.common.navigator.Navigator
import com.ncapdevi.fragnav.FragNavController
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    fun provideActivity(): AppCompatActivity = activity

    @Provides
    fun providesLayoutInflater(activity: AppCompatActivity): LayoutInflater = LayoutInflater.from(activity)

    @Provides
    fun provideFragmentManager(activity: AppCompatActivity): FragmentManager = activity.supportFragmentManager

    @ActivityScope
    @Provides
    fun provideFragmentNavController(fragmentManager: FragmentManager, activity: AppCompatActivity): FragNavController {
        val frameContainerId = (activity as BaseActivity).getContainerRoot()
        return FragNavController(fragmentManager, frameContainerId)
    }

    @ActivityScope
    @Provides
    fun provideNavigator(activity: AppCompatActivity, fragNavController: FragNavController): Navigator {
        return Navigator(activity as BaseActivity, fragNavController)
    }

}