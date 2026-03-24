package com.sarang.torang.compose.component.menu


sealed interface Menu {
    class Category(val category : String, val price: String = "") : Menu
    class PairItem(val menus : Pair<MenuData, MenuData>) : Menu
    class Item(val menus : MenuData) : Menu
}

data class MenuData(val menuName: String = "",
                    val price   : String = "",
                    val url     : String = "")