package com.henimex.tutorial.kmp.workflow

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.henimex.tutorial.kmp.workflow.components.BottomBar
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        BottomBar()
    }
}