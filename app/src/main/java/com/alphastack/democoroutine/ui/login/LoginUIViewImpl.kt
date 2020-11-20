package com.alphastack.democoroutine.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alphastack.democoroutine.R
import kotlinx.android.synthetic.main.login_fragment.view.*

class LoginUIViewImpl(
        inflater: LayoutInflater,
        parent: ViewGroup?
) : LoginUIView() {

    init {
        setRootView(inflater.inflate(R.layout.login_fragment, parent, false))
        setUpViews()
        setUpViewListeners()
    }

    private fun setUpViews() {

    }

    private fun setUpViewListeners() {
        getRootView().buttonLogin.setOnClickListener {
            getListeners().forEach { it.onLoginClicked() }
        }
    }

    override fun disableLogin() {
        getRootView().buttonLogin.isEnabled = false
    }

    override fun enableLogin() {
        getRootView().buttonLogin.isEnabled = true
    }
}