package com.sarang.torang.compose.component.menu

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier


typealias RestaurantMenuPullToRefresh = @Composable (RestaurantMenuPullToRefreshData) -> Unit

data class RestaurantMenuPullToRefreshData(
    val modifier : Modifier,
    val isRefreshing: Boolean,
    val onRefresh: (() -> Unit),
    val contents: @Composable () -> Unit
)

val LocalRestaurantMenuPullToRefresh = compositionLocalOf<RestaurantMenuPullToRefresh> {
    // 기본 구현: 경고 로그 출력
    @Composable {
        Log.w("__RestaurantMenuPullToRefresh", "no RestaurantMenuPullToRefresh")
        it.contents.invoke()
    }
}