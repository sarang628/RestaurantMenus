package com.sarang.torang.usecase

import com.sarang.torang.compose.component.menu.Menu

interface GetMenuUseCase {
    suspend fun invoke(restaurantId: Int): List<Menu>
}