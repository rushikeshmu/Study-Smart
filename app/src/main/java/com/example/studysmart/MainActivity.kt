package com.example.studysmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.toArgb
import com.example.studysmart.domain.model.Session
import com.example.studysmart.domain.model.Subject
import com.example.studysmart.domain.model.Task
import com.example.studysmart.presentation.NavGraphs
import com.example.studysmart.presentation.theme.StudySmartTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudySmartTheme {
                    DestinationsNavHost(navGraph = NavGraphs.root)
                }
            }
        }
    }


val subjects = listOf(
    Subject(name = "English", goalHours = 10f, colors = Subject.subjectCardColors.map { it.toArgb() } , subjectId = 0),
    Subject(name = "Math", goalHours = 10f, colors = Subject.subjectCardColors.map { it.toArgb() }, subjectId = 1),
    Subject(name = "Science", goalHours = 10f, colors = Subject.subjectCardColors.map { it.toArgb() }, subjectId = 2),
    Subject(name = "History", goalHours = 10f, colors = Subject.subjectCardColors.map { it.toArgb() }, subjectId = 3)
)

val tasks = listOf(
    Task(
        title = "Prepare notes",
        description = "",
        priority = 0,
        dueDate = 0L,
        relatedToSubject = "",
        isComplete = false,
        taskSubjectId = 0,
        taskId = 1
    ),
    Task(
        title = "Do Homework",
        description = "",
        priority = 1,
        dueDate = 0L,
        relatedToSubject = "",
        isComplete = true,
        taskSubjectId = 0,
        taskId = 1
    ),
    Task(
        title = "Go Coaching",
        description = "",
        priority = 2,
        dueDate = 0L,
        relatedToSubject = "",
        isComplete = false,
        taskSubjectId = 0,
        taskId = 1
    ),
    Task(
        title = "Assignment",
        description = "",
        priority = 1,
        dueDate = 0L,
        relatedToSubject = "",
        isComplete = false,
        taskSubjectId = 0,
        taskId = 1
    ),
    Task(
        title = "Write Poems",
        description = "",
        priority = 0,
        dueDate = 0L,
        relatedToSubject = "",
        isComplete = true,
        taskSubjectId = 0,
        taskId = 1
    ),

    )

val sessions = listOf(
    Session(
        relatedSubject = "English",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0
    ),

    Session(
        relatedSubject = "Physics",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0
    ),
    Session(
        relatedSubject = "Maths",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0
    ),
    Session(
        relatedSubject = "History",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0
    )
)
