package com.sarang.torang.compose.menu

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sarang.torang.compose.component.menu.Menu
import com.sarang.torang.usecase.GetMenuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantMenuViewModel @Inject constructor(val getMenuUseCase: GetMenuUseCase) :
    ViewModel() {
    val tag = "__RestaurantMenuViewModel"
    var uiState: List<Menu> by mutableStateOf(ArrayList()); private set
    var isRefresh by mutableStateOf(false); private set

    fun loadMenu(restaurantId: Int) {
        isRefresh = true
        viewModelScope.launch {
            try {
                uiState = getMenuUseCase.invoke(restaurantId)
            } catch (e: Exception) {
                Log.e(tag, "$e")
            } finally {
                isRefresh = false
            }
        }
    }
}