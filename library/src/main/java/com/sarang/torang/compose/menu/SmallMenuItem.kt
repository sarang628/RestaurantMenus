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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sarang.torang.compose.component.menu.LocalRestaurantMenuImageLoader
import com.sarang.torang.compose.component.menu.MenuData
import com.sarang.torang.compose.component.menu.RestaurantMenuImageLoaderData

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
                .padding(start = 4.dp, bottom = 4.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color(0x66000000))
        ) {
            Column(Modifier.padding(horizontal = 4.dp, vertical = 2.dp)) {
                Text(
                    text = "${menu.menuName}(${menu.price})",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    lineHeight = 12.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSmallMenuItem() {
    SmallMenuItem(menu =MenuData(menuName = "menuName", price = "100$")) //preview
}
