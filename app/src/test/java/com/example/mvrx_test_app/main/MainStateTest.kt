package com.example.mvrx_test_app.main

import com.airbnb.mvrx.Loading
import com.example.mvrx_test_app.test_utils.shouldEqual
import com.nhaarman.mockitokotlin2.mock
import org.junit.Test

class MainStateTest {

    @Test
    fun init_hasLoadingDefaultValueForLoadingState() {
        MainState(mock()).loading shouldEqual Loading()
    }
}