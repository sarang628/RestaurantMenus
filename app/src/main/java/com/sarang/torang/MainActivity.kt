package com.sarang.torang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sarang.torang.compose.component.menu.LocalRestaurantMenuImageLoader
import com.sarang.torang.compose.component.menu.LocalRestaurantMenuPullToRefresh
import com.sarang.torang.compose.component.menu.MenuData
import com.sarang.torang.compose.menu.RestaurantMenu
import com.sarang.torang.compose.menu.RestaurantMenuScreen
import com.sarang.torang.di.restaurant_menu_di.CustomRestaurantMenuPullToRefresh
import com.sarang.torang.di.restaurant_menu_di.customRestaurantMenuImageLoader
import com.sryang.torang.ui.TorangTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController : NavHostController = rememberNavController()
            TorangTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(Modifier.padding(innerPadding)) {
                        NavHost(navController = navHostController, startDestination = "menu") {
                            composable("menu") {
                                Column {
                                    Button({ navHostController.navigate("RestaurantMenu") }) { Text("RestaurantMenu") }
                                    Button({ navHostController.navigate("RestaurantMenuScreen") }) { Text("RestaurantMenuScreen") }
                                }
                            }
                            composable("RestaurantMenu") {
                                RestaurantMenu(
                                    list = listOf(
                                        MenuData.dummy(),
                                        MenuData.dummy(),
                                        MenuData.dummy(),
                                        MenuData.dummy(),
                                        MenuData.dummy(),
                                        MenuData.dummy(),
                                    )
                                )
                            }
                            composable("RestaurantMenuScreen") {
                                CompositionLocalProvider(LocalRestaurantMenuImageLoader provides customRestaurantMenuImageLoader,
                                    LocalRestaurantMenuPullToRefresh provides CustomRestaurantMenuPullToRefresh
                                ) {
                                    RestaurantMenuScreen(restaurantId = 1)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}