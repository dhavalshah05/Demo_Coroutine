package com.alphastack.democoroutine.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alphastack.democoroutine.di.presentation.PresentationComponent
import com.alphastack.democoroutine.ui.common.fragment.BaseFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class LoginFragment : BaseFragment(), LoginUIView.Listener {

    private lateinit var uiView: LoginUIView

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun injectFragment(presentationComponent: PresentationComponent) {
        presentationComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        uiView = uiViewFactory.getLoginUIView(container)
        return uiView.getRootView()
    }

    override fun onStart() {
        super.onStart()
        uiView.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        uiView.unregisterListener(this)
    }

    override fun onLoginClicked() {
        coroutineScope.launch {
            uiView.disableLogin()
            val dataWrapper = LoginDataSource.loginUser("John", "123")
            if (dataWrapper.throwable != null) {
                Timber.d(dataWrapper.throwable)
            } else if (dataWrapper.responseBody != null) {
                Timber.d(dataWrapper.responseBody.toString())
            }
            uiView.enableLogin()
        }
    }

}
