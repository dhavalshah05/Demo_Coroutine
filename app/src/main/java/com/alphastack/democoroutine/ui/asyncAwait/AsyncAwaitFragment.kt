package com.alphastack.democoroutine.ui.asyncAwait

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alphastack.democoroutine.di.presentation.PresentationComponent
import com.alphastack.democoroutine.ui.common.fragment.BaseFragment
import kotlinx.coroutines.*
import timber.log.Timber

class AsyncAwaitFragment : BaseFragment(), AsyncAwaitUIView.Listener {

    private lateinit var uiView: AsyncAwaitUIView

    override fun injectFragment(presentationComponent: PresentationComponent) {
        presentationComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        uiView = uiViewFactory.getAsyncAwaitUIView(container)
        return uiView.getRootView()
    }

    override fun onStart() {
        super.onStart()
        uiView.registerListener(this)
        doWork()
    }

    override fun onStop() {
        super.onStop()
        uiView.unregisterListener(this)
    }

    override fun onNavigateUpClicked() {
        navigator.navigateBack()
    }

    private fun doWork() {
        val launch = GlobalScope.launch {
            val dataDeferred = getUserNameFromNetworkAsync(this)
            Timber.d("Not Cancelled")
            val data = dataDeferred.await()
            Timber.d(data)
        }
        GlobalScope.launch {
            delay(1000)
            launch.cancel()
        }
    }

    private suspend fun getUserNameFromNetworkAsync(parentScope: CoroutineScope): Deferred<String> {
        return parentScope.async {
            if (!isActive) {
                Timber.d("Cancelling Job")
                "EMPTY"
            }

            Timber.d("Retrieving Data From Network")
            delay(3000)
            Timber.d("Still in suspend function")
            "ABC"
        }
    }
}