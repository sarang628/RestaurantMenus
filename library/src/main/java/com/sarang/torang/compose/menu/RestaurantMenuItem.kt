package com.sarang.torang.compose.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarang.torang.compose.component.menu.AndroidViewRatingBar
import com.sarang.torang.compose.component.menu.LocalRestaurantMenuImageLoader
import com.sarang.torang.compose.component.menu.Menu
import com.sarang.torang.compose.component.menu.RestaurantMenuImageLoaderData

/**
 * https://www.indiennechicago.com/menus-reservation
 */

fun LazyListScope.restaurantMenuList(
    menus: List<Menu> = listOf(),
    progressTintColor: Color? = null,
    columnCount: Int = 1,
) {
    items(menus){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            when(it){
                is Menu.Category -> {
                    Text(it.category)
                }
                is Menu.Item -> {
                    SmallMenuItem(
                        menu = it,
                        progressTintColor = progressTintColor,
                        modifier = Modifier.weight(1f)
                    )
                }
                else -> {}
            }
        }
    }
}

/**
 * Vegetarian & Vegan $135
 * Non-Vegetarian & Pescatarian $155
 * Spirit Free Pairing $70
 * Indienne Wine Pairing $95
 * Reserve Wine Upgrade $50
 *
 * View
 *
 * NON VEGETARIAN TASTING MENU
 * VEGETARIAN TASTING MENU
 * PESCATARIAN TASTING MENU
 * VEGAN TASTING MENU
 * BAR MENU
 */
@Preview
@Composable
fun PreviewRestaurantMenuColumn(modifier: Modifier = Modifier) {
    LazyColumn {
        restaurantMenuList(
        //@formatter:off
        menus = sampleData,
        columnCount = 3,
        //@formatter:on
    )
    }
}

val sampleData = listOf(
    Menu.Category(category = "Main"),
    Menu.Item(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_728.jpg",
        menuName = "Vegetarian & Vegan",
        price = "135$"),
    Menu.Item(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_740.jpg",
        menuName = "Non-Vegetarian & Pescatarian",
        price = "155$"),
    Menu.Item(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_753.jpg",
        menuName = "Spirit Free Pairing",
        price = "70$"),
    Menu.Item(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_765.jpg",
        menuName = "Indienne Wine Pairing ",
        price = "95$"),
    Menu.Item(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg",
        menuName = "Reserve Wine Upgrade",
        price = "50$"),
    Menu.Category(category = "Bar Menu"),
    Menu.Item(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg",
        menuName = "AVOCADO BHEL\n"+
                "Ember Roasted Ponk, Green Apple, Tamarind (V)",
        price = "15$"),
    Menu.Item(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg",
        menuName = "AVOCADO BHEL\n"+
                "Ember Roasted Ponk, Green Apple, Tamarind (V)",
        price = "15$"),
    Menu.Item(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg",
        menuName = "CAULIFLOWER KOLIWADA\n"+
                "Carrot Pachadi, Curry Leaf, Podi (V)",
        price = "15$"),
    Menu.Item(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg",
        menuName = "GREEN PEA & FAVA KULCHA\n"+
                "Tomato Pachadi, Umbria Truffle (V)",
        price = "18$"),
    Menu.Item(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg",
        menuName = "PORK BELLY BBQ\n"+
                "Pomegranate, Compressed Apple, Apricot, Mustard",
        price = "15$"),
    Menu.Item(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg",
        menuName = "OCTOPUS XEC XEC\n"+
                "Cauliflower Mousseline, Pickled Kohlrabi, Fermented Gooseberry Gel, Black garlic",
        price = "18$"),
    Menu.Item(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg",
        menuName = "CHICKEN GUSTABA\n"+
                "Amul Cheese Fondue, Périgord Truffle, Coriander",
        price = "18$"),

    )

@Composable
fun MenuItem(
    modifier: Modifier = Modifier,
    menu: Menu.Item,
    progressTintColor: Color? = null,
) {
    Box(
        modifier = modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(start = 2.dp, end = 2.dp, top = 2.dp, bottom = 2.dp)
    ) {
        LocalRestaurantMenuImageLoader.current.invoke(
            RestaurantMenuImageLoaderData(modifier        = Modifier.fillMaxSize(),
                                               url             = menu.url,
                                               progressSize           = null,
                                               errorIconSize          = null,
                                               contentScale    = ContentScale.Crop)
        )

        Box(
            Modifier
                .align(Alignment.BottomStart)
                .clip(RoundedCornerShape(5.dp))
                .padding(start = 8.dp, bottom = 8.dp)
                .background(Color(0x99000000))
        ) {
            Column(Modifier.padding(4.dp)) {
                AndroidViewRatingBar(rating = 3.0f, progressTintColor = progressTintColor)
                Text(
                    text = menu.menuName + if (menu.price.isNotEmpty()) "(${menu.price})" else "",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun SmallMenuItem(
    modifier: Modifier = Modifier,
    menu: Menu.Item,
    progressTintColor: Color? = null
) {
    Box(
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth()
            .padding(start = 2.dp, end = 2.dp, top = 2.dp, bottom = 2.dp)
    ) {
        LocalRestaurantMenuImageLoader.current.invoke(
            RestaurantMenuImageLoaderData(modifier = Modifier.clip(RoundedCornerShape(8.dp))
                                                                  .fillMaxSize(),
                                               url = menu.url,
                                               progressSize = 20.dp,
                                               errorIconSize = 20.dp,
                                               contentScale = ContentScale.Crop)
        )
        Box(
            Modifier
                .align(Alignment.BottomStart)
                .clip(RoundedCornerShape(5.dp))
                .padding(start = 4.dp, bottom = 4.dp)
                .background(Color(0x66000000))
        ) {
            Column(Modifier.padding(2.dp)) {
                Text(
                    text = "${menu.menuName}(${menu.price})",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis

                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewMenuItem() {
    MenuItem(menu = Menu.Item()) //preview
}

@Preview
@Composable
fun PreviewSmallMenuItem() {
    SmallMenuItem(menu = Menu.Item(menuName = "menuName", price = "100$")) //preview
}

@Preview
@Composable
fun MenuDetail(){
    Text("NON-VEGETARIAN TASTING MENU\n" +
            "\n" +
            "DHOKLA AERO\n" +
            "\n" +
            "Curry Leaf, Mustard \n" +
            "\n" +
            "\u200B\n" +
            "\n" +
            "PANI PURI\n" +
            "\n" +
            "Passion Fruit, Green Apple, Buckwheat\n" +
            "\n" +
            "\u200B\n" +
            "\n" +
            "MUSHROOM GALOUTI\n" +
            "\n" +
            "Eclair, Goat Cheese, Truffle\n" +
            "\n" +
            "\u200B\n" +
            "\n" +
            "YOGURT CHAAT\n" +
            "\n" +
            "Strawberry, Mint, Tamarind\u200B\n" +
            "\n" +
            " \n" +
            "\n" +
            "SCALLOP CAFREAL\n" +
            "\n" +
            "Miso, Golden Kaluga, Young Garlic\n" +
            "\n" +
            "\u200B\n" +
            "\n" +
            "\u200BLOBSTER GHEE ROAST\n" +
            "\n" +
            "Ela Ada, Sunchoke, Mango\n" +
            "\n" +
            "(Supplemental Course - \$28)\n" +
            "\n" +
            "\u200B\n" +
            "\n" +
            "LAMB KEBAB\n" +
            "\n" +
            "Shami, Ribs, Endive, Pickled Jicama\n" +
            "\n" +
            "(Supplemental Bread- Chili Cheese Kulcha- \$6)\n" +
            "\n" +
            "\u200B\n" +
            "\n" +
            "CHICKEN MAKHNI\n" +
            "\n" +
            "Red Pepper Makhni, Fenugreek\n" +
            "\n" +
            "Black Dairy Dal, Garlic Naan\n" +
            "\n" +
            " \n" +
            "\n" +
            "KAJU KATLI\n" +
            "\n" +
            "Honeycomp, Nougat, Milk Ice Cream\u200B\n" +
            "\n" +
            "\u200B\n" +
            "\n" +
            "TREATS\n" +
            "\n" +
            "Coffee\n" +
            "\n" +
            "Mango and Ginger")
}