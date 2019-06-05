package com.example.mvrx_test_app.test_utils

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat

infix fun <T> T.shouldEqual(target: T?) {
    assertThat(this, equalTo(target))
}


infix fun <T> T.shouldBeInstanceOf(target: Class<*>) {
    assertThat(this, instanceOf(target))
}