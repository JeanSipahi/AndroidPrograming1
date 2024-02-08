package com.example.studentdisplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.studentdisplay.ui.theme.StudentDisplayTheme
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentDisplayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StudentDisplay()
                }
            }
        }
    }
}

@Composable
fun StudentDisplay() {
    var studentNumber by remember { mutableStateOf("") }
    var studentName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = studentNumber,
            onValueChange = { studentNumber = it },
            label = { Text("Enter student number") }
        )
        Button(
            onClick = {
                studentName = getStudentName(studentNumber)
            },
            enabled = studentNumber.isNotBlank()
        ) {
            Text("Display Student Name")
        }
        Text(text = "Student Name: $studentName")
    }
}

fun getStudentName(studentNumber: String): String {
    return when (studentNumber) {
        "123555" -> "Anna"
        "123888" -> "Kim"
        "123999" -> "Carl"
        else -> ""
    }
}

@Preview(showBackground = true)
@Composable
fun StudentDisplayPreview() {
    StudentDisplayTheme {
        StudentDisplay()
    }
}
