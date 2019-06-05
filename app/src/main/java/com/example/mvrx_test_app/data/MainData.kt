package com.example.mvrx_test_app.data

import java.io.Serializable

data class MainData(
    private val title: String,
    private val description: String,
    private val url: String
) : Serializable