package com.example.studysmart.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.studysmart.presentation.theme.*

@Entity
data class Subject(
    val name: String,
    val goalHours: Float,
    val colors: List<Int>,
    @PrimaryKey(autoGenerate = true)
    val subjectId: Int? = null
) {
    companion object{
        val subjectCardColors = listOf(md_theme_dark_onError, md_theme_dark_background)
    }
}