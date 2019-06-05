package com.example.mvrx_test_app.main

import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.test.MvRxTestRule
import com.airbnb.mvrx.withState
import com.example.mvrx_test_app.test_utils.shouldEqual
import com.nhaarman.mockitokotlin2.mock
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule val mvrxRule = MvRxTestRule()

    private val state = MainState(mock())
    private val viewModel = MainViewModel(state)
    
    @Test
    fun onLoadingFailed_setsLoadingStateToFailWithProperException() {
        // Never pass
        val error = Throwable()
        viewModel.onLoadingFailed(error)

        withState(viewModel) {
            it.loading shouldEqual Fail(error)
        }
    }

    @Test
    fun onLoadingSuccess_setsLoadingStateToSuccess() {
        // Sometimes passes
        viewModel.onLoadingSuccess()
        withState(viewModel) {
            it.loading shouldEqual Success(Unit)
        }
    }
}