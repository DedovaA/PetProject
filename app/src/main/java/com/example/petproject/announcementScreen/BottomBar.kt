package com.example.petproject.announcementScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.petproject.consts.uiConsts.bottomNavigationSelectedTextStyle
import com.example.petproject.consts.uiConsts.bottomNavigationTextStyle
import com.example.petproject.consts.uiConsts.mainBlue
import com.example.petproject.navigation.BottomBarItems

@Composable
fun BottomBar(
    currentRoute: String,
    onItemClick: (String) -> Unit
) {
    val items = listOf(
        BottomBarItems.AdList,
        BottomBarItems.CreateAd,
        BottomBarItems.Profile
    )

    BottomAppBar(
        contentColor = Color.White,
        backgroundColor = mainBlue,
        modifier = Modifier.height(90.dp),
        elevation = 2.dp
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        when (currentRoute) {
                            item.route -> {
                                Icon(
                                    painterResource(id = item.selectIconId),
                                    contentDescription = item.route
                                )
                                Text(
                                    text = item.label,
                                    style = bottomNavigationSelectedTextStyle
                                )
                            }
                            else -> {
                                Icon(
                                    painterResource(id = item.iconId),
                                    contentDescription = item.route
                                )
                                Text(
                                    text = item.label,
                                    style = bottomNavigationTextStyle
                                )
                            }
                        }
                    }
                },
                selected = (currentRoute == item.route),
                alwaysShowLabel = true,
                onClick = { onItemClick.invoke(item.route) }
            )
        }
    }
}