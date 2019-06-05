package com.example.mvrx_test_app

import android.os.Bundle
import com.airbnb.mvrx.BaseMvRxActivity
import com.example.mvrx_test_app.data.MainData
import com.example.mvrx_test_app.main.MainFragment

class MainActivity : BaseMvRxActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = MainFragment
            .get(
                MainData(
                    title = "Super Title",
                    description = "Super Description",
                    url = "https://github.com/airbnb/MvRx"
                )
            )

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
