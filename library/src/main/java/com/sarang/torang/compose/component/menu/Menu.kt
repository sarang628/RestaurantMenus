package com.sarang.torang.compose.component.menu

data class MenuData(val menuName: String,
                    val price   : Float,
                    val url     : String) {
    companion object
}

fun MenuData.Companion.empty(): MenuData = MenuData(menuName = "",
                                                    price = 0f,
                                                    url = "")
fun MenuData.Companion.dummy(): MenuData {
    return MenuData(menuName    = "menuName",
                    price       = 10000.0f,
                    url         = "")
}