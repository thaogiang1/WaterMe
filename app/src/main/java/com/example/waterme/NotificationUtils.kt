package com.example.waterme

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.waterme.R

object NotificationUtils {

    fun showNotification(context: Context, plantName: String) {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Tạo NotificationChannel nếu API >= 26
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "water_me_channel",
                "Water Me Notifications",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Nhắc nhở tưới cây"
            }
            notificationManager.createNotificationChannel(channel)
        }

        val builder = NotificationCompat.Builder(context, "water_me_channel")
            .setSmallIcon(R.drawable.ic_water_drop) // Đổi icon nếu cần
            .setContentTitle("Đã đến giờ tưới cây 🌱")
            .setContentText("Đừng quên tưới cây: $plantName")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        notificationManager.notify(plantName.hashCode(), builder.build())
    }
}
