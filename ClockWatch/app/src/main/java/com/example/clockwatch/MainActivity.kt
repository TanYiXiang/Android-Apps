package com.example.clockwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clockwatch.ui.main.ClockFragment
import com.example.clockwatch.ui.main.StopWatchFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, StopWatchFragment.newInstance()).commitNow()
        }
    }

}
