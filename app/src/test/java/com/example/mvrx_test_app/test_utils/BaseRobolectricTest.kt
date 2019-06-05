package com.example.mvrx_test_app.test_utils

import android.os.Build
import com.example.mvrx_test_app.App
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = App::class, sdk = [Build.VERSION_CODES.O])
abstract class BaseRobolectricTest {

    protected val context = RuntimeEnvironment.application!!
}