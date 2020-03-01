package com.example.clockwatch.ui.main

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StopWatchViewModel : ViewModel() {
    private val _isRunning = MutableLiveData<Boolean>()
    val  isRunning: LiveData<Boolean>
        get() =  _isRunning


    init{
        _isRunning.value = true
    }

    fun toggleRunning(){
        _isRunning.value = !isRunning.value!!
    }

    fun calculateOffset(stopWatchBase: Long) : Long{
        return SystemClock.elapsedRealtime() - stopWatchBase
    }

}
