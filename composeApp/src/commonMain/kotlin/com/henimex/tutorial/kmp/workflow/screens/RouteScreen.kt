package com.henimex.tutorial.kmp.workflow.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.henimex.tutorial.kmp.workflow.entities.Item
import com.henimex.tutorial.kmp.workflow.screens.stacks.FirstScreen
import com.henimex.tutorial.kmp.workflow.screens.stacks.FourthScreen
import com.henimex.tutorial.kmp.workflow.screens.stacks.SecondScreen
import com.henimex.tutorial.kmp.workflow.screens.stacks.ThirdScreen
import kotlinx.serialization.json.Json

@Composable
fun RouteScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main-screen") {
        composable(route = Screens.Main.route) {
            MainScreen(navController = navController)
        }

        composable(route = Screens.Detail.route) {
            DetailScreen(navController = navController)
        }

        composable(route = Screens.DetailedData.route) {
            val data = it.arguments?.getString("data")
            DetailedScreen(data = data)
        }

        composable(route = Screens.ItemCollection.route) {
            val itemCollectionJson = it.arguments?.getString("item")!!
            val item = Json.decodeFromString<Item>(itemCollectionJson)
            ItemCollectionScreen(navController = navController, data = item)
        }

        composable(route = "first") {
            FirstScreen(navController = navController)
        }

        composable(route = "second") {
            SecondScreen(navController = navController)
        }

        composable(route = "third") {
            ThirdScreen(navController = navController)
        }

        composable(route = "fourth") {
            FourthScreen(navController = navController)
        }
    }
}