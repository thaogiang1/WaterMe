package com.example.waterme.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.waterme.NotificationUtils
import com.example.waterme.WaterReminderWorker

class WaterReminderWorker(context: Context, workerParams: WorkerParameters) : CoroutineWorker(context, workerParams) {

    companion object {
        const val nameKey = "plantName"
    }

    override suspend fun doWork(): Result {
        val plantName = inputData.getString(nameKey)

        plantName?.let {
            NotificationUtils.showNotification(applicationContext, it)
        }

        return Result.success()
    }
}
