package com.example.clockwatch.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class ClockFragmentViewModel : ViewModel() {

    private val _timeZoneString = MutableLiveData<String>()
    val timeZoneString: LiveData<String>
        get() = _timeZoneString

    private val _dateString = MutableLiveData<String>()
    val dateString: LiveData<String>
        get() = _dateString

    init {
        _timeZoneString.value = TimeZone.getDefault().id.toString()
        _dateString.value = getDate()
    }

    private fun getDate(): String {
        val date = LocalDateTime.now()
        val dayOfWeek = date.dayOfWeek.toString()
        val formatter = DateTimeFormatter.ofPattern(" dd-MM-yyyy ")

        return  dayOfWeek + formatter.format(date)
    }

}
