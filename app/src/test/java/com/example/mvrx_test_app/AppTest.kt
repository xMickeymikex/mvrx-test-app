package com.example.mvrx_test_app

import androidx.multidex.MultiDexApplication
import com.example.mvrx_test_app.test_utils.BaseRobolectricTest
import com.example.mvrx_test_app.test_utils.shouldBeInstanceOf
import org.junit.Test

class AppTest: BaseRobolectricTest() {

    @Test
    fun app_shouldBeMultidexApplication() {
        context.applicationContext shouldBeInstanceOf MultiDexApplication::class.java
    }
}