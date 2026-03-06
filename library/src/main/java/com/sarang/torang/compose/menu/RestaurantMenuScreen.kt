package com.sarang.torang.compose.menu

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.sarang.torang.compose.component.menu.LocalRestaurantMenuPullToRefresh
import com.sarang.torang.compose.component.menu.MenuData
import com.sarang.torang.compose.component.menu.RestaurantMenuPullToRefreshData
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantMenuScreen(viewModel          : RestaurantMenuViewModel   = hiltViewModel(),
                         restaurantId       : Int                       = 0,
                         progressTintColor  : Color?                    = null,
                         columnCount        : Int                       = 1,
                         isSmallMenuItem    : Boolean                   = false) {
    val coroutine = rememberCoroutineScope()
    LaunchedEffect(key1 = restaurantId) {
        viewModel.loadMenu(restaurantId)
    }
    val uiState = viewModel.uiState
    val state = rememberPullToRefreshState()
    LocalRestaurantMenuPullToRefresh.current.invoke(
        RestaurantMenuPullToRefreshData(
            modifier = Modifier,
            isRefreshing = viewModel.isRefresh,
            onRefresh = { coroutine.launch { viewModel.loadMenu(restaurantId) } },
            contents = {
                if (uiState.isNotEmpty()) {
                    RestaurantMenu(list = uiState,
                                   isSmallMenuItem = isSmallMenuItem,
                                   progressTintColor = progressTintColor,
                                   columnCount = columnCount)
                } else {
                    Text("등록된 메뉴가 없습니다.")
                }
            })
    )
}
@Composable
fun RestaurantMenu(
    list: List<MenuData>,
    progressTintColor: Color? = null,
    columnCount: Int = 1,
    isSmallMenuItem: Boolean = false
) {
    LazyVerticalGrid(columns = GridCells.Fixed(columnCount), content = {
        items(list) {
            if (!isSmallMenuItem) {
                MenuItem(
                    menu = it,
                    progressTintColor = progressTintColor
                )
            } else {
                SmallMenuItem(
                    menu = it,
                    progressTintColor = progressTintColor
                )
            }
        }
    })
}