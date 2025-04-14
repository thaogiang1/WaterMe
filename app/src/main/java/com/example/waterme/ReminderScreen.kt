package com.example.waterme

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.concurrent.TimeUnit

@Composable
fun ReminderScreen(plantName: String, context: Context) {
    var timeInMinutes by remember { mutableStateOf("1") }

    val workManagerRepository = WorkManagerWaterRepository(context)

    Column(Modifier.padding(16.dp)) {
        Text("Nhắc tưới cây: $plantName")
        OutlinedTextField(
            value = timeInMinutes,
            onValueChange = { timeInMinutes = it },
            label = { Text("Sau bao nhiêu phút?") }
        )
        Button(onClick = {
            // Lên lịch nhắc
            workManagerRepository.scheduleReminder(
                plantName,
                timeInMinutes.toLong(),
                TimeUnit.MINUTES
            )
        }) {
            Text("Đặt nhắc")
        }
    }
}
