package com.example.mvrx_test_app

import com.example.mvrx_test_app.main.MainFragment
import com.example.mvrx_test_app.test_utils.BaseRobolectricTest
import com.example.mvrx_test_app.test_utils.shouldBeInstanceOf
import org.junit.Test
import org.robolectric.Robolectric.setupActivity

class MainActivityTest: BaseRobolectricTest() {

    private val activity = setupActivity(MainActivity::class.java)

    @Test
    fun onCreate_injectsMainFragmentToContainer() {
        activity
            .supportFragmentManager
            .findFragmentById(R.id.fragment_container) shouldBeInstanceOf MainFragment::class.java
    }
}