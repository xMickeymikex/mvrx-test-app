package com.example.mvrx_test_app.main

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MvRxState
import com.example.mvrx_test_app.data.MainData

data class MainState @JvmOverloads constructor(
    val data: MainData,
    val loading: Async<Unit> = Loading()
): MvRxState