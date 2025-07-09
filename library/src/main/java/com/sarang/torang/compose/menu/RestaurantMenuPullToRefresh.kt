package com.sarang.torang.compose.menu

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf


typealias RestaurantMenuPullToRefresh = @Composable (
    isRefreshing: Boolean,
    onRefresh: (() -> Unit),
    contents: @Composable () -> Unit
) -> Unit

val LocalRestaurantMenuPullToRefresh = compositionLocalOf<RestaurantMenuPullToRefresh> {
    // 기본 구현: 경고 로그 출력
    @Composable { isRefreshing, onRefresh, contents ->
        Log.w("__RestaurantMenuPullToRefresh", "no RestaurantMenuPullToRefresh")
        contents.invoke()
    }
}