package com.example.mvrx_test_app.main

import androidx.lifecycle.TestMvRxActivity
import com.airbnb.mvrx.test.MvRxTestRule
import com.example.mvrx_test_app.test_utils.BaseRobolectricTest
import com.example.mvrx_test_app.test_utils.shouldEqual
import com.nhaarman.mockitokotlin2.mock
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.robolectric.Robolectric

class MainFragmentTest: BaseRobolectricTest() {

    @get:Rule val mvRxRule = MvRxTestRule()

    private val activity = Robolectric.setupActivity(TestMvRxActivity::class.java)
    private val state = MainState(mock())
    private val viewModel = MainViewModel(state)
    private lateinit var fragment: MainFragment

    @Before
    fun setUp() {
        activity.addViewModel(viewModel)
        fragment = MainFragment()
        activity.supportFragmentManager.beginTransaction().add(fragment, null).commitNow()
    }

    @Test
    fun onLoadingFailed_setsErrorAsTextInErrorView() {
        // Never pass
        fragment.invokeLoadingError()
        fragment.view!!.error_background.text shouldEqual "Error"
    }

    @Test
    fun onLoadingSuccess_setsSuccessAsTextInErrorView() {
        // Sometimes passes
        fragment.invokeLoadingSuccess()
        fragment.view!!.error_background.text shouldEqual "Success"
    }
    @Test
    fun onLoadingFailed_setsErrorAsTextInErrorView_sleep() {
        // Never pass
        fragment.invokeLoadingError()
        Thread.sleep(1000)
        fragment.view!!.error_background.text shouldEqual "Error"
    }

    @Test
    fun onLoadingSuccess_setsSuccessAsTextInErrorView_sleep() {
        // Sometimes passes
        fragment.invokeLoadingSuccess()
        Thread.sleep(1000)
        fragment.view!!.error_background.text shouldEqual "Success"
    }
}