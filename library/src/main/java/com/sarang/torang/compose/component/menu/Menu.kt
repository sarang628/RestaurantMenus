package com.sarang.torang.compose.component.menu


sealed interface Menu {
    class Category(val category : String)
    class Menu(val menuName: String = "",
               val price   : String = "",
               val url     : String = "")
}

data class MenuData(val menuName: String = "",
                    val price   : String = "",
                    val url     : String = "") {
    companion object
}

fun MenuData.Companion.empty(): MenuData = MenuData(menuName = "",
                                                    price = "100$",
                                                    url = "")
fun MenuData.Companion.dummy(): MenuData {
    return MenuData(menuName    = "menuName",
                    price       = "100$",
                    url         = "")
}