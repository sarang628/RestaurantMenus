package com.sarang.torang

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable


internal fun NavGraphBuilder.menu(navHostController : NavHostController){
    composable("menu") {
        Column {
            Button({ navHostController.navigate("RestaurantMenu") }) { Text("RestaurantMenu") }
            Button({ navHostController.navigate("RestaurantMenuScreen") }) { Text("RestaurantMenuScreen") }
        }
    }
}