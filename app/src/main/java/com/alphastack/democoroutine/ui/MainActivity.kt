package com.alphastack.democoroutine.ui

import android.os.Bundle
import com.alphastack.democoroutine.R
import com.alphastack.democoroutine.di.presentation.PresentationComponent
import com.alphastack.democoroutine.ui.common.activity.BaseActivity

class MainActivity : BaseActivity() {

    override fun injectActivity(presentationComponent: PresentationComponent) {
        presentationComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}