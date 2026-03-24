package com.sarang.torang

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MenuNavigation(navHostController : NavHostController = rememberNavController(),
                   restaurantMenu : @Composable () -> Unit = {},
                   restaurantMenuScreen : @Composable () -> Unit = {}) {
    NavHost(navController = navHostController, startDestination = "menu") {
        menu(navHostController)
        composable("RestaurantMenu") {
            restaurantMenu.invoke()
        }
        composable("RestaurantMenuScreen") {
            restaurantMenuScreen.invoke()
        }
    }
}