# Usage

```
data class MenuData(val menuName: String,
                    val price   : Float,
                    val url     : String) {
    companion object
}
```

```
@Preview
@Composable
fun PreviewMenuItem() {
    MenuItem(menu = MenuData.dummy()) //preview
}
```

```
@Preview
@Composable
fun PreviewSmallMenuItem() {
SmallMenuItem(menu = MenuData.empty().copy(menuName = "menuName", price = 4000f)) //preview
}
```

```
if (uiState.isNotEmpty()) {
    LazyColumn { restaurantMenuList(menus = uiState,
                                    progressTintColor = progressTintColor) }
    } else {
        Text("등록된 메뉴가 없습니다.")
    }
```