package com.alphastack.democoroutine.ui.common.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alphastack.democoroutine.di.presentation.PresentationComponent
import com.alphastack.democoroutine.di.presentation.PresentationModule
import com.alphastack.democoroutine.ui.common.activity.BaseActivity

abstract class BaseFragment : Fragment() {

    private val presentationComponent: PresentationComponent by lazy {
        val activityComponent = (requireActivity() as BaseActivity).activityComponent
        activityComponent.newPresentationComponent(PresentationModule())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injectFragment(presentationComponent)
        super.onCreate(savedInstanceState)
    }

    abstract fun injectFragment(presentationComponent: PresentationComponent)

}