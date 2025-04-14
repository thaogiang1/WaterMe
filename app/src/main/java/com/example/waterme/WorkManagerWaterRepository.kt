package com.example.waterme

import android.content.Context
import androidx.work.*
import com.example.waterme.worker.WaterReminderWorker
import java.util.concurrent.TimeUnit

class WorkManagerWaterRepository(private val context: Context) {

    fun scheduleReminder(plantName: String, duration: Long) {
        val data = workDataOf(WaterReminderWorker.nameKey to plantName)

        val request = OneTimeWorkRequestBuilder<WaterReminderWorker>()
            .setInputData(data)
            .setInitialDelay(duration, TimeUnit.MINUTES)
            .build()

        WorkManager.getInstance(context).enqueueUniqueWork(
            "$plantName-$duration",
            ExistingWorkPolicy.REPLACE,
            request
        )
    }
}
