package com.alphastack.democoroutine.ui.common.activity

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.alphastack.democoroutine.StarterApplication
import com.alphastack.democoroutine.di.activity.ActivityComponent
import com.alphastack.democoroutine.di.activity.ActivityModule
import com.alphastack.democoroutine.di.presentation.PresentationComponent
import com.alphastack.democoroutine.di.presentation.PresentationModule
import com.alphastack.democoroutine.ui.common.fragment.BaseFragment
import com.alphastack.democoroutine.ui.common.navigator.Navigator
import com.ncapdevi.fragnav.FragNavController
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var fragNavController: FragNavController

    @Inject
    lateinit var navigator: Navigator

    val activityComponent: ActivityComponent by lazy {
        val appComponent = (application as StarterApplication).appComponent
        appComponent.newActivityComponent(ActivityModule(this))
    }

    private val presentationComponent: PresentationComponent by lazy {
        activityComponent.newPresentationComponent(PresentationModule())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injectActivity(presentationComponent)
        super.onCreate(savedInstanceState)

        // Initialize FragNavController
        fragNavController.rootFragments = listOf(getRootFragment())
        fragNavController.initialize(FragNavController.TAB1, savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        fragNavController.onSaveInstanceState(outState)
    }

    override fun onBackPressed() {
        navigator.navigateBack()
    }

    abstract fun injectActivity(presentationComponent: PresentationComponent)

    @IdRes
    abstract fun getContainerRoot(): Int

    abstract fun getRootFragment(): BaseFragment

}