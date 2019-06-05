package com.example.mvrx_test_app.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.MvRx
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.activityViewModel
import com.example.mvrx_test_app.R
import com.example.mvrx_test_app.data.MainData
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: BaseMvRxFragment() {

    internal val viewModel: MainViewModel by activityViewModel()

    override fun invalidate() {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel
            .selectSubscribe(MainState::loading) {
                when(it) {
                    is Error -> error_background.text = "Error"
                    is Success -> error_background.text = "Success"
                }
            }
    }

    fun invokeLoadingError() = viewModel.onLoadingFailed(Throwable())

    fun invokeLoadingSuccess() = viewModel.onLoadingSuccess()

    companion object {

        fun get(data: MainData) = MainFragment().apply {
            arguments = Bundle().apply {
                putSerializable(MvRx.KEY_ARG, data)
            }
        }
    }
}