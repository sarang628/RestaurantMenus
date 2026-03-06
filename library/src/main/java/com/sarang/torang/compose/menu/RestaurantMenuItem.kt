package com.sarang.torang.compose.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
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
import com.sarang.torang.compose.component.menu.MenuData
import com.sarang.torang.compose.component.menu.RestaurantMenuImageLoaderData
import com.sarang.torang.compose.component.menu.dummy
import com.sarang.torang.compose.component.menu.empty

fun LazyListScope.restaurantMenuList(
    menus: List<MenuData> = listOf(),
    progressTintColor: Color? = null,
    columnCount: Int = 1,
    isSmallMenuItem: Boolean = false,
) {
    val menuList : List<List<MenuData>> = menus.chunked(columnCount)
    items(menuList.size){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            menuList[it].forEach { menu ->
                if (isSmallMenuItem) {
                    SmallMenuItem(
                        menu = menu,
                        progressTintColor = progressTintColor,
                        modifier = Modifier.weight(1f)
                    )
                } else {
                    MenuItem(
                        menu = menu,
                        progressTintColor = progressTintColor,
                    )
                }
            }
            // 빈 칸 채우기
            repeat(columnCount - menuList[it].size) {
                Spacer(modifier = Modifier.weight(1f))
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
        menus = listOf(
            MenuData.dummy().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_728.jpg", menuName = "Vegetarian & Vegan", price = "135$"),
            MenuData.dummy().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_740.jpg", menuName = "Non-Vegetarian & Pescatarian", price = "155$"),
            MenuData.dummy().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_753.jpg", menuName = "Spirit Free Pairing", price = "70$"),
            MenuData.dummy().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_765.jpg", menuName = "Indienne Wine Pairing ", price = "95$"),
            MenuData.dummy().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_43_58_780.jpg", menuName = "Reserve Wine Upgrade", price = "50$"),
            MenuData.dummy().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_46_46_782.jpg", menuName = "BAR MENU", price = ""),
//            MenuData.dummy().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_46_46_792.jpg", menuName = "hanburger", price = "100$"),
//            MenuData.dummy().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_46_46_801.jpg", menuName = "hanburger", price = "100$"),
//            MenuData.dummy().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_46_46_812.jpg", menuName = "hanburger", price = "100$"),
//            MenuData.dummy().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_46_46_822.jpg", menuName = "hanburger", price = "100$"),
//            MenuData.dummy().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_49_20_923.jpg", menuName = "hanburger", price = "100$"),
//            MenuData.dummy().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_49_36_394.jpg", menuName = "hanburger", price = "100$"),
//            MenuData.dummy().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_49_36_404.jpg", menuName = "hanburger", price = "100$"),
//            MenuData.dummy().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_49_53_226.jpg", menuName = "hanburger", price = "100$"),
//            MenuData.dummy().copy(url = "http://sarang628.iptime.org:89/review_images/1/214/2024-08-18/01_49_53_237.jpg", menuName = "hanburger", price = "100$"),
        ),
        columnCount = 3,
        isSmallMenuItem = true,
        //@formatter:on
    )
    }
}

@Composable
fun MenuItem(
    modifier: Modifier = Modifier,
    menu: MenuData,
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
    menu: MenuData,
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
    MenuItem(menu = MenuData.dummy()) //preview
}

@Preview
@Composable
fun PreviewSmallMenuItem() {
    SmallMenuItem(menu = MenuData.empty().copy(menuName = "menuName", price = "100$")) //preview
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