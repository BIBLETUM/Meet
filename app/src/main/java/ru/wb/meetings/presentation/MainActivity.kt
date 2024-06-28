package ru.wb.meetings.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.wb.meetings.presentation.theme.MeetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeetsTheme {
                MeetsMainScreen()
            }
        }
    }
}