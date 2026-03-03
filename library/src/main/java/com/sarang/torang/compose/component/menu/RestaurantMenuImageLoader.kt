package com.sarang.torang.compose.component.menu

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp

typealias RestaurantMenuImageLoader = @Composable (
    RestaurantMenuImageLoaderData
) -> Unit

data class RestaurantMenuImageLoaderData(
    val modifier        : Modifier,
    val url             : String,
    val progressSize    : Dp?,
    val errorIconSize   : Dp?,
    val contentScale    : ContentScale?
)

val LocalRestaurantMenuImageLoader = compositionLocalOf<RestaurantMenuImageLoader> {
    // 기본 구현: 경고 로그 출력
    @Composable {
        Log.w("__LocalRestaurantMenuImageLoader", "No ImageLoader provided.")
    }
}