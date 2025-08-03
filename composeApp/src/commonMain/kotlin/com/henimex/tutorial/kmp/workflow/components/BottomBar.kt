package com.henimex.tutorial.kmp.workflow.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.henimex.tutorial.kmp.workflow.screens.RouteScreen
import kmpworkflow.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun BottomBar() {
    val selectedItem = remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomAppBar (
                content = {
                    NavigationBarItem(
                        selected = selectedItem.value == 0,
                        onClick = {selectedItem.value = 0},
                        icon = {
                            Icon(Icons.Rounded.Menu, contentDescription = "Localized description")
                        }
                    )
                }
            )
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (selectedItem.value == 0) {RouteScreen("main-screen")}
            if (selectedItem.value == 1) {RouteScreen("settings")}
        }
    }
}