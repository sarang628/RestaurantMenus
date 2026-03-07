package com.sarang.torang.compose.component.menu


sealed interface Menu {
    class Category(val category : String) : Menu
    class Item(val menuName: String = "",
               val price   : String = "",
               val url     : String = "") : Menu
}