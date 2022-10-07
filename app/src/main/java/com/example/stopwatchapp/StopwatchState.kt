package com.example.stopwatchapp

import android.os.Build
import android.os.SystemClock
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.*
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class StopwatchState {
    var formattedTime by mutableStateOf("00:00:000")
    private var coroutineScope = CoroutineScope(Dispatchers.Main)
    private var isTimerActive = false
    private var timeMillis = 0L
    private var lastTimeStamp = 0L

    @RequiresApi(Build.VERSION_CODES.O)
    fun start() {
        if (isTimerActive) return

        coroutineScope.launch {
            lastTimeStamp = System.currentTimeMillis()
            isTimerActive = true
            while (isTimerActive) {
                delay(10L)
                timeMillis += System.currentTimeMillis() - lastTimeStamp
                lastTimeStamp = System.currentTimeMillis()
                formattedTime = formatTime(timeMillis)
            }
        }
    }

    fun pause() {
        isTimerActive = false
    }

    fun reset() {
        coroutineScope.cancel()
        coroutineScope = CoroutineScope(Dispatchers.Main)
        timeMillis = 0L
        isTimerActive = false
        formattedTime = "00:00:000"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun formatTime(timeMillis: Long): String {
        val localDateTime = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(timeMillis), ZoneId.systemDefault()
        )
        val formatter = DateTimeFormatter.ofPattern("mm:ss:SSS", Locale.getDefault())
        return localDateTime.format(formatter)
    }

}