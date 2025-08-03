package com.henimex.tutorial.kmp.workflow.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.henimex.tutorial.kmp.workflow.entities.Item
import kotlinx.serialization.json.Json

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    val counter = remember { mutableStateOf(0) }
    var transferData by remember { mutableStateOf("") }

    LaunchedEffect(key1 = true) {
        println("Main Screen : Launched Effect Triggered")
    }

    DisposableEffect(Unit) {
        onDispose {
            println("Main Screen : Disposable Effect Triggered")
        }
    }

    Scaffold(topBar = {
        println("Main Screen : Scaffold Triggered")
        TopAppBar(title = {
            Text(text = "MainScreen")
        })
    }) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Counter : [ ${counter.value} ]")

            Button(onClick = {
                counter.value++
            }) {
                Text(text = "Increment")
            }

            Button(onClick = {
                navController.navigate(Screens.Detail.route)
            }) {
                Text(text = "Go To Detail Screen")
            }

            Button(onClick = {
                val item = Item(5, "MacPro", true)
                //IMPORTANT NOTE "/" CAUSES CRASH ON TRANSFER !! THESE OPERATIONS MUST CHECK OR LIMIT
                val jsonItem = Json.encodeToString(item)
                navController.navigate(Screens.ItemCollection.createRoute(jsonItem))
            }) {
                Text(text = "Go To Collections")
            }

            Button(onClick = {
                navController.navigate("first")
            }) {
                Text(text = "1st")
            }

            Button(onClick = {
                navController.navigate("settings")
            }) {
                Text(text = "Settings")
            }


            Row(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = transferData,
                    onValueChange = { transferData = it },
                    label = { Text("Enter Data To Transfer") },
                    singleLine = true,
                    modifier = Modifier
                        .weight(0.5f)
                )

                Spacer(modifier = Modifier
                    .weight(0.025f))

                Button(onClick = {
                    navController.navigate(Screens.DetailedData.createRoute(transferData))
                },
                    modifier = Modifier
                        .weight(0.3f)
                        .padding(top = 5.dp)) {
                    Text(text = "Transfer")
                }
            }
        }
    }
}