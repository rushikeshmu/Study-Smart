package com.example.studysmart.util

import androidx.compose.ui.graphics.Color
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

enum class Priority(val title: String, val color: Color, val value: Int) {
    LOW(title = "Low", color = Color(0xFF608C2D), value = 0),
    MEDIUM(title = "Medium", color = Color(0xFFECB40A), value = 1),
    HIGH(title = "High", color = Color(0xFFBA1A1A), value = 2);


    companion object {
        fun fromInt(value: Int) = entries.firstOrNull() { it.value == value } ?: MEDIUM
    }
}

fun Long?.changeMillisToDateString(): String {
    val date: LocalDate = this?.let {
        Instant
            .ofEpochMilli(it)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
    } ?: LocalDate.now()
    return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))

}

fun Long.toHours(): Float {
    val hours = this.toFloat() / 3600f
    return "%.2f".format(hours).toFloat()
}