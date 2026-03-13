package com.sarang.torang.compose.menu

import com.sarang.torang.compose.component.menu.Menu
import com.sarang.torang.compose.component.menu.MenuData

val sampleData = listOf(
    Menu.Category(category = "Main"),
    Menu.PairItem(Pair(MenuData(
        url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_728.jpg",
        menuName = "Vegetarian & Vegan",
        price = "135$"),
        MenuData(
            url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_740.jpg",
            menuName = "Non-Vegetarian & Pescatarian",
            price = "155$"))),
    Menu.PairItem(Pair(
        MenuData(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_753.jpg",
            menuName = "Spirit Free Pairing",
            price = "70$"),
        MenuData(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_765.jpg",
            menuName = "Indienne Wine Pairing ",
            price = "95$"))),
    Menu.PairItem(Pair(
        MenuData(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg",
            menuName = "Reserve Wine Upgrade",
            price = "50$"),
        MenuData()
    )),
    Menu.Category(category = "Bar Menu"),
    Menu.PairItem(Pair(MenuData(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg",
        menuName = "AVOCADO BHEL\n"+
                "Ember Roasted Ponk, Green Apple, Tamarind (V)",
        price = "15$"),
        MenuData(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg",
            menuName = "AVOCADO BHEL\n"+
                    "Ember Roasted Ponk, Green Apple, Tamarind (V)",
            price = "15$"),)),
    Menu.PairItem(Pair(MenuData(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg",
        menuName = "CAULIFLOWER KOLIWADA\n"+
                "Carrot Pachadi, Curry Leaf, Podi (V)",
        price = "15$"),
        MenuData(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg",
            menuName = "GREEN PEA & FAVA KULCHA\n"+
                    "Tomato Pachadi, Umbria Truffle (V)",
            price = "18$"))),
    Menu.PairItem(Pair(MenuData(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg",
        menuName = "PORK BELLY BBQ\n"+
                "Pomegranate, Compressed Apple, Apricot, Mustard",
        price = "15$"),
        MenuData(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg",
            menuName = "OCTOPUS XEC XEC\n"+
                    "Cauliflower Mousseline, Pickled Kohlrabi, Fermented Gooseberry Gel, Black garlic",
            price = "18$"))),
    Menu.PairItem(Pair(MenuData(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg",
        menuName = "CHICKEN GUSTABA\n"+
                "Amul Cheese Fondue, Périgord Truffle, Coriander",
        price = "18$"), MenuData()))

)