package com.sarang.torang.compose.menu

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantMenuScreen(
    viewModel: RestaurantMenuViewModel = hiltViewModel(),
    restaurantId: Int,
    progressTintColor: Color? = null,
    columnCount: Int = 1,
) {
    val coroutine = rememberCoroutineScope()
    LaunchedEffect(key1 = restaurantId, block = {
        viewModel.loadMenu(restaurantId)
    })
    val uiState = viewModel.uiState
    val state = rememberPullToRefreshState()
    LocalRestaurantMenuPullToRefresh.current.invoke(
        false,
        {
            coroutine.launch {
                viewModel.loadMenu(restaurantId)
                //state.updateState(RefreshIndicatorState.Default)
            }
        }) {
        if (uiState.isNotEmpty()) {
            RestaurantMenu(
                list = uiState,
                progressTintColor = progressTintColor,
                columnCount = columnCount
            )
        } else {
            Text("등록된 메뉴가 없습니다.")
        }
    }
}

@Composable
fun RestaurantMenu(
    list: List<MenuData>,
    progressTintColor: Color? = null,
    columnCount: Int = 1,
    isSmallMenuItem: Boolean = false
) {
    LazyVerticalGrid(columns = GridCells.Fixed(columnCount), content = {
        items(list.size) {
            var menu = list[it]
            if (!isSmallMenuItem) {
                MenuItem(
                    menu = menu,
                    progressTintColor = progressTintColor
                )
            } else {
                SmallMenuItem(
                    menu = menu,
                    progressTintColor = progressTintColor
                )
            }
        }
    })
}