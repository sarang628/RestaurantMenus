package com.sarang.torang.usecase

import com.sarang.torang.compose.menu.MenuData

interface GetMenuUseCase {
    suspend fun invoke(restaurantId: Int): List<MenuData>
}