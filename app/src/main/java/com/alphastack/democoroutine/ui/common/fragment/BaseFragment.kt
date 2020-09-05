package com.alphastack.democoroutine.ui.common.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alphastack.democoroutine.di.presentation.PresentationComponent
import com.alphastack.democoroutine.di.presentation.PresentationModule
import com.alphastack.democoroutine.ui.common.activity.BaseActivity
import com.alphastack.democoroutine.ui.common.navigator.Navigator
import com.alphastack.democoroutine.ui.common.uiView.UIViewFactory
import javax.inject.Inject

abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var uiViewFactory: UIViewFactory

    @Inject
    lateinit var navigator: Navigator

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