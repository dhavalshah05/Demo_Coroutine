package com.alphastack.democoroutine.ui.home

import android.os.Bundle
import com.alphastack.democoroutine.R
import com.alphastack.democoroutine.di.presentation.PresentationComponent
import com.alphastack.democoroutine.ui.common.activity.BaseActivity
import com.alphastack.democoroutine.ui.common.fragment.BaseFragment
import com.alphastack.democoroutine.ui.common.navigator.Navigator
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun injectActivity(presentationComponent: PresentationComponent) {
        presentationComponent.inject(this)
    }

    override fun getContainerRoot(): Int {
        return R.id.containerRoot
    }

    override fun getRootFragment(): BaseFragment {
        return HomeFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}