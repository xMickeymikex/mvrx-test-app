package com.example.mvrx_test_app.main

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.Success
import com.example.mvrx_test_app.BuildConfig

class MainViewModel(initialState: MainState) : BaseMvRxViewModel<MainState>(initialState, BuildConfig.DEBUG) {

    fun onLoadingSuccess() = setState {
        copy(loading = Success(Unit))
    }

    fun onLoadingFailed(throwable: Throwable) = setState {
        copy(loading = Fail(throwable))
    }
}