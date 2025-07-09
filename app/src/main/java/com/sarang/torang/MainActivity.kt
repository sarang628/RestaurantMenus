package com.sarang.torang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sarang.torang.compose.menu.MenuData
import com.sarang.torang.compose.menu.RestaurantMenu
import com.sarang.torang.ui.theme.RestaurantMenusTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RestaurantMenusTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RestaurantMenu(list = listOf(
                        MenuData.dummy(),
                        MenuData.dummy(),
                        MenuData.dummy(),
                        MenuData.dummy(),
                        MenuData.dummy(),
                        MenuData.dummy(),
                    ))
                }
            }
        }
    }
}