package com.example.studysmart.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.studysmart.domain.model.Subject

@Composable
fun AddSubjectDialog(
    isOpen: Boolean,
    title: String = "Add/Update Subject",
    selectedColors: List<Color>,
    subjectName: String,
    goalHours: String,
    onColorChange: () -> Unit,
    onSubjectNameChange: (String) -> Unit,
    onGoalHoursChange: (String) -> Unit,
    onDismissRequest: () -> Unit,
    onConfirmButtonClick: () -> Unit,
) {
    var goalHoursError by rememberSaveable { mutableStateOf<String?>(null) }
    var subjectNameError by rememberSaveable { mutableStateOf<String?>(null) }

    subjectNameError = when{
        subjectName.isBlank() -> "Subject name is required."
        subjectName.isDigitsOnly() -> "Invalid Text"
        subjectName.length < 3 -> "Subject name must be at least 3 characters."
        subjectName.length > 20 -> "Subject name must be less than 20 characters."
        else -> null
    }

    goalHoursError = when{
        goalHours.isBlank() -> "Study hours is required."
        goalHours.toFloatOrNull() == null -> "Invalid number format."
        goalHours.toFloat() < 1f -> "Study hours must be at least 1 hour."
        goalHours.toFloat() > 24f -> "Study hours must be less than 24 hours."
        else -> null
    }

    if (isOpen) {
        AlertDialog(
            onDismissRequest = onDismissRequest,
            title = { Text(text = title) },
            text = {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Subject.subjectCardColors.forEach { colors ->
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .clip(CircleShape)
                                    .border(
                                        width = 1.dp,
                                        color = Color.Black,
//                                        color = if (colors == selectedColors) Color.Black else Color.Transparent,
                                        shape = CircleShape
                                    )
                                    .background(
                                        brush = Brush.linearGradient(
                                            colors = listOf(Color.White, Color.Black)
                                        )
                                    )
                                    .clickable {onColorChange }
                            )
                        }

                    }
                    OutlinedTextField(
                        value = subjectName ,
                        onValueChange =  onSubjectNameChange  ,
                        label = {Text(text = "Subject Name")},
                        singleLine = true,
                        isError = subjectNameError != null && subjectName.isNotBlank(),
                        supportingText = { Text(text = subjectNameError.orEmpty())}
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = goalHours ,
                        onValueChange = onGoalHoursChange ,
                        label = {Text(text = "Study Hours")},
                        singleLine = true,
                        isError = goalHoursError != null && goalHours.isNotBlank(),
                        supportingText = { Text(text = goalHoursError.orEmpty())},
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
            },
            dismissButton = {
                TextButton(onClick = onDismissRequest) {
                    Text(text = "Cancel")
                }
            },
            confirmButton = {
                TextButton(
                    onClick = onConfirmButtonClick,
                    enabled = subjectNameError == null && goalHoursError == null
                ) {
                    Text(text = "Save")
                }
            }
        )
    }
}