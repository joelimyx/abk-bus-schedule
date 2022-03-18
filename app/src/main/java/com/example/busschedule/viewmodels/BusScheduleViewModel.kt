package com.example.busschedule.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.busschedule.database.schedule.Schedule
import com.example.busschedule.database.schedule.ScheduleDoa
import kotlinx.coroutines.flow.Flow
import java.lang.IllegalArgumentException

class BusScheduleViewModel(private val scheduleDoa: ScheduleDoa): ViewModel(){

    fun fullSchedule(): Flow<List<Schedule>> = scheduleDoa.getAll()

    fun scheduleForStopName(stopName: String): Flow<List<Schedule>> = scheduleDoa.getByStopName(stopName)
}

class BusScheduleViewModelFactory(private val scheduleDoa: ScheduleDoa)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BusScheduleViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return BusScheduleViewModel(scheduleDoa) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}