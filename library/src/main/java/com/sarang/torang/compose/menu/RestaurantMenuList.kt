package com.sarang.torang.compose.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sarang.torang.compose.component.menu.Menu

/**
 * https://www.indiennechicago.com/menus-reservation
 */

fun LazyListScope.restaurantMenuList(
    menus: List<Menu> = listOf(),
    progressTintColor: Color? = null
) {
    items(menus){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            when(it){
                is Menu.Category -> {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = it.category,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                is Menu.Item -> {
                    SmallMenuItem(
                        menu = it.menus,
                        progressTintColor = progressTintColor,
                        modifier = Modifier.weight(1f)
                    )
                }
                is Menu.PairItem -> {
                    SmallMenuItem(
                        menu = it.menus.first,
                        progressTintColor = progressTintColor,
                        modifier = Modifier.weight(1f)
                    )
                    SmallMenuItem(
                        menu = it.menus.second,
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
fun PreviewRestaurantMenuColumn() {
    LazyColumn {
        restaurantMenuList(
            //@formatter:off
            menus = sampleData
            //@formatter:on
        )
    }
}