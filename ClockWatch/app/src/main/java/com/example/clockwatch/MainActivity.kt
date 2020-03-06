package com.example.clockwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.clockwatch.databinding.MainActivityBinding
import com.example.clockwatch.ui.main.ClockFragment
import com.example.clockwatch.ui.main.StopWatchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.main_activity)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ClockFragment(),"Clock")
        adapter.addFragment(StopWatchFragment(),"StopWatch")
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

}
