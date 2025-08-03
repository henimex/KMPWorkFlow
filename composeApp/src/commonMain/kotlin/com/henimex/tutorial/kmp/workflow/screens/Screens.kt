package com.henimex.tutorial.kmp.workflow.screens

import com.henimex.tutorial.kmp.workflow.entities.Item

sealed class Screens(val route: String) {
    object Main : Screens("main-screen")
    object Detail : Screens("detail-screen")
    object DetailedData : Screens("detailed-screen/{data}") {
        fun createRoute(data: String) = "detailed-screen/$data"
    }

    object ItemCollection : Screens("item-collection-screen/{item}"){
        fun createRoute(item: String) = "item-collection-screen/$item"
    }
}