package com.alphastack.democoroutine.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alphastack.democoroutine.di.presentation.PresentationComponent
import com.alphastack.democoroutine.ui.common.fragment.BaseFragment
import com.alphastack.democoroutine.ui.common.uiView.UIViewFactory
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    @Inject
    lateinit var uiViewFactory: UIViewFactory

    private lateinit var uiView: HomeUIView

    override fun injectFragment(presentationComponent: PresentationComponent) {
        presentationComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        uiView = uiViewFactory.getHomeUIView(container)
        return uiView.getRootView()
    }

}