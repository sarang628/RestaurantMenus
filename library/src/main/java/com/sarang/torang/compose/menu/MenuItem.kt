package com.sarang.torang.compose.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.sarang.torang.compose.component.menu.MenuData
import com.sarang.torang.compose.component.menu.RestaurantMenuImageLoaderData

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
                url             = menu.menus.url,
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
                    text = menu.menus.menuName + if (menu.menus.price.isNotEmpty()) "(${menu.menus.price})" else "",
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

@Preview
@Composable
fun PreviewMenuItem() {
    MenuItem(menu = Menu.Item(MenuData())) //preview
}