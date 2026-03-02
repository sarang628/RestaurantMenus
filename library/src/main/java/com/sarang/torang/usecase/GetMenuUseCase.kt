package com.sarang.torang.usecase

import com.sarang.torang.compose.component.menu.MenuData

interface GetMenuUseCase {
    suspend fun invoke(restaurantId: Int): List<MenuData>
}